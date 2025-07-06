package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.TeamMemberRequestDTO;
import com.smart.ourSite.dto.response.TeamMemberResponseDTO;
import com.smart.ourSite.model.TeamMember;
import com.smart.ourSite.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }


    public List<TeamMemberResponseDTO> getAllMembers() {
        return teamMemberRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public TeamMemberResponseDTO getMemberById(Long id) {
        TeamMember member = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team member not found"));
        return mapToResponseDTO(member);
    }


    public TeamMemberResponseDTO createMember(TeamMemberRequestDTO dto) {
        TeamMember member = new TeamMember();
        member.setMemberName(dto.getMemberName());
        member.setMemberRole(dto.getMemberRole());
        member.setImage(dto.getImage());

        return mapToResponseDTO(teamMemberRepository.save(member));
    }


    public TeamMemberResponseDTO updateMember(Long id, TeamMemberRequestDTO dto) {
        TeamMember member = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team member not found"));

        member.setMemberName(dto.getMemberName());
        member.setMemberRole(dto.getMemberRole());
        member.setImage(dto.getImage());

        return mapToResponseDTO(teamMemberRepository.save(member));
    }


    public void deleteMember(Long id) {
        if (!teamMemberRepository.existsById(id)) {
            throw new RuntimeException("Team member not found");
        }
        teamMemberRepository.deleteById(id);
    }

    private TeamMemberResponseDTO mapToResponseDTO(TeamMember member) {
        return new TeamMemberResponseDTO(
                member.getMemberId(),
                member.getMemberName(),
                member.getMemberRole(),
                member.getImage()
        );
    }
}
