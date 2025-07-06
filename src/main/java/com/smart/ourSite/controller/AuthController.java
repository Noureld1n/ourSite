package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.request.ForgotPasswordRequestDTO;
import com.smart.ourSite.dto.request.ResetPasswordRequestDTO;
import com.smart.ourSite.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        return authService.login(
                loginRequest.get("email"),
                loginRequest.get("password")
        );
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody AdminRequestDTO dto) {
        return authService.createAdmin(dto);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequestDTO request) {
        return authService.forgotPassword(request);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO request) {
        return authService.resetPassword(request);
    }
}
