package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.AccountUpdateRequestDTO;
import com.smart.ourSite.dto.response.AccountResponseDTO;
import com.smart.ourSite.security.AdminDetails;
import com.smart.ourSite.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/profile")
@RequiredArgsConstructor
public class AccountController {

    private final AdminService adminService;

    // GET /admin/profile
    @GetMapping
    public ResponseEntity<AccountResponseDTO> getProfile(
            @AuthenticationPrincipal AdminDetails adminDetails) {
        String email = adminDetails.getUsername();
        return ResponseEntity.ok(adminService.getProfile(email));
    }

    // PUT /admin/profile
    @PutMapping
    public ResponseEntity<?> updateProfile(
            @AuthenticationPrincipal AdminDetails adminDetails,
            @Valid @RequestBody AccountUpdateRequestDTO dto) {
        String email = adminDetails.getUsername();
        AccountResponseDTO updated = adminService.updateProfile(email, dto);
        return ResponseEntity.ok().body(
                ResponseEntity.ok().body("Your account details have been updated successfully.")
        );
    }
}
