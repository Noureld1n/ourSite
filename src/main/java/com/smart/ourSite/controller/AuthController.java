package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.request.ForgotPasswordRequestDTO;
import com.smart.ourSite.dto.request.ResetPasswordRequestDTO;
import com.smart.ourSite.model.Admin;
import com.smart.ourSite.repository.AdminRepository;
import com.smart.ourSite.security.AdminDetails;
import com.smart.ourSite.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(adminDetails.getUsername());

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "email", adminDetails.getUsername()
            ));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body(Map.of(
                    "error", "Invalid email or password."
            ));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody AdminRequestDTO dto) {
        if (adminRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Admin with this email already exists");
        }

        Admin admin = new Admin();
        admin.setAdminName(dto.getAdminName());
        admin.setImage(dto.getImage() != null ? dto.getImage() : "default-admin-image.png");
        admin.setEmail(dto.getEmail());

        admin.setAdminPassword(passwordEncoder.encode(dto.getAdminPassword()));

        admin.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);

        adminRepository.save(admin);
        return ResponseEntity.ok("Admin created successfully");
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequestDTO request) {
        var adminOpt = adminRepository.findByEmail(request.getEmail());
        if (adminOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("No account found with this email. Please try again.");
        }

        Admin admin = adminOpt.get();

        String resetToken = jwtUtil.generateToken(admin.getEmail());

        log.info("Reset token for {}: {}", admin.getEmail(), resetToken);

        return ResponseEntity.ok("A password reset link has been sent to your email.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO request) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match. Please try again.");
        }


        String email;
        try {
            email = jwtUtil.extractUsername(request.getToken());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid or expired reset token.");
        }

        var adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid token or user not found.");
        }

        Admin admin = adminOpt.get();
        admin.setAdminPassword(passwordEncoder.encode(request.getNewPassword()));
        adminRepository.save(admin);

        return ResponseEntity.ok("Your password has been successfully reset. You can now log in.");
    }
}
