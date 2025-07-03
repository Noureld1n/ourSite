package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.response.AdminResponseDTO;
import com.smart.ourSite.dto.request.AccountUpdateRequestDTO;
import com.smart.ourSite.dto.response.AccountResponseDTO;
import java.util.List;

public interface AdminService {

    List<AdminResponseDTO> getAllAdmins();

    AdminResponseDTO getAdminById(Long id);

    AdminResponseDTO createAdmin(AdminRequestDTO dto);

    AdminResponseDTO updateAdmin(Long id, AdminRequestDTO dto);

    void deleteAdmin(Long id);

    AccountResponseDTO getProfile(String email);
    AccountResponseDTO updateProfile(String email, AccountUpdateRequestDTO dto);
}

