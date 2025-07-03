package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.TeamMemberRequestDTO;
import com.smart.ourSite.dto.response.TeamMemberResponseDTO;
import com.smart.ourSite.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/team-members")
@RequiredArgsConstructor
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @GetMapping
    public ResponseEntity<List<TeamMemberResponseDTO>> getAllTeamMembers() {
        List<TeamMemberResponseDTO> members = teamMemberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberResponseDTO> getTeamMemberById(@PathVariable Long id) {
        TeamMemberResponseDTO member = teamMemberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity<TeamMemberResponseDTO> createTeamMember(@RequestBody TeamMemberRequestDTO dto) {
        TeamMemberResponseDTO createdMember = teamMemberService.createMember(dto);
        return ResponseEntity.ok(createdMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamMemberResponseDTO> updateTeamMember(
            @PathVariable Long id,
            @RequestBody TeamMemberRequestDTO dto) {
        TeamMemberResponseDTO updatedMember = teamMemberService.updateMember(id, dto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable Long id) {
        teamMemberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
