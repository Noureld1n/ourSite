package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.TeamMemberRequestDTO;
import com.smart.ourSite.dto.response.TeamMemberResponseDTO;

import java.util.List;

public interface TeamMemberService {

    List<TeamMemberResponseDTO> getAllMembers();

    TeamMemberResponseDTO getMemberById(Long id);

    TeamMemberResponseDTO createMember(TeamMemberRequestDTO dto);

    TeamMemberResponseDTO updateMember(Long id, TeamMemberRequestDTO dto);

    void deleteMember(Long id);
}
