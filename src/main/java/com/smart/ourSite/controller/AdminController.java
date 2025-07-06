package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.request.AdminUpdateDTO;
import com.smart.ourSite.dto.response.AdminResponseDTO;
import com.smart.ourSite.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> listAdmins(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(adminService.getAdmins(search));
    }

    @PostMapping
    public ResponseEntity<?> createAdmin(@Valid @RequestBody AdminRequestDTO dto) {
        return ResponseEntity.ok(adminService.createAdmin(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateDTO dto) {
        return ResponseEntity.ok(adminService.updateAdminFields(id, dto));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<?> activateAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.activateAdmin(id));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deactivateAdmin(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.removeAdmin(id));
    }
}
