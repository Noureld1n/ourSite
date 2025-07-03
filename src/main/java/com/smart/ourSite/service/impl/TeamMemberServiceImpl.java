package com.smart.ourSite.service.impl;

import com.smart.ourSite.dto.request.TeamMemberRequestDTO;
import com.smart.ourSite.dto.response.TeamMemberResponseDTO;
import com.smart.ourSite.model.TeamMember;
import com.smart.ourSite.repository.TeamMemberRepository;
import com.smart.ourSite.service.TeamMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public List<TeamMemberResponseDTO> getAllMembers() {
        return teamMemberRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamMemberResponseDTO getMemberById(Long id) {
        TeamMember member = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team member not found"));
        return mapToResponseDTO(member);
    }

    @Override
    public TeamMemberResponseDTO createMember(TeamMemberRequestDTO dto) {
        TeamMember member = new TeamMember();
        member.setMemberName(dto.getMemberName());
        member.setMemberRole(dto.getMemberRole());
        member.setImage(dto.getImage());

        return mapToResponseDTO(teamMemberRepository.save(member));
    }

    @Override
    public TeamMemberResponseDTO updateMember(Long id, TeamMemberRequestDTO dto) {
        TeamMember member = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team member not found"));

        member.setMemberName(dto.getMemberName());
        member.setMemberRole(dto.getMemberRole());
        member.setImage(dto.getImage());

        return mapToResponseDTO(teamMemberRepository.save(member));
    }

    @Override
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
