package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.request.AdminUpdateDTO;
import com.smart.ourSite.model.Admin;
import com.smart.ourSite.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    // 1. List admins with optional search by first or last name
    @GetMapping
    public List<Admin> listAdmins(@RequestParam(required = false) String search) {
        if (search == null || search.isEmpty()) {
            return adminRepository.findAll();
        } else {
            // simple search: filter by adminName containing search term (you can improve this)
            return adminRepository.findByAdminNameContainingIgnoreCase(search);
        }
    }

    // 2. Create new admin
    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody AdminRequestDTO dto) {
        if (adminRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Admin with this email already exists"));
        }

        Admin admin = new Admin();
        admin.setAdminName(dto.getAdminName());
        admin.setImage(dto.getImage() != null ? dto.getImage() : "default-admin-image.png");
        admin.setEmail(dto.getEmail());
        admin.setAdminPassword(passwordEncoder.encode(dto.getAdminPassword()));
        admin.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        admin.setRegisterDate(LocalDateTime.now());

        adminRepository.save(admin);

        return ResponseEntity.ok(Map.of("message", "User added successfully."));
    }

    // 3. Update admin details (except email)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable Long id, @RequestBody AdminUpdateDTO dto) {
        return adminRepository.findById(id).map(admin -> {
            admin.setAdminName(dto.getAdminName());
            admin.setImage(dto.getImage());
            admin.setIsActive(dto.getIsActive());
            adminRepository.save(admin);
            return ResponseEntity.ok(Map.of("message", "User updated successfully."));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Activate admin
    @PatchMapping("/{id}/activate")
    public ResponseEntity<?> activateAdmin(@PathVariable Long id) {
        return adminRepository.findById(id).map(admin -> {
            admin.setIsActive(true);
            adminRepository.save(admin);
            return ResponseEntity.ok(Map.of("message", "User has been activated successfully."));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Deactivate admin
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateAdmin(@PathVariable Long id) {
        return adminRepository.findById(id).map(admin -> {
            admin.setIsActive(false);
            adminRepository.save(admin);
            return ResponseEntity.ok(Map.of("message", "User has been deactivated successfully."));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 6. Delete admin (optional)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "User has been deleted successfully."));
        }
        return ResponseEntity.notFound().build();
    }
}
