package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.TeamMemberRequestDTO;
import com.smart.ourSite.dto.response.TeamMemberResponseDTO;
import com.smart.ourSite.service.TeamMemberService;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(teamMemberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberResponseDTO> getTeamMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(teamMemberService.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<TeamMemberResponseDTO> createTeamMember(@Valid @RequestBody TeamMemberRequestDTO dto) {
        return ResponseEntity.ok(teamMemberService.createMember(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamMemberResponseDTO> updateTeamMember(
            @PathVariable Long id,
            @Valid @RequestBody TeamMemberRequestDTO dto) {
        return ResponseEntity.ok(teamMemberService.updateMember(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable Long id) {
        teamMemberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
