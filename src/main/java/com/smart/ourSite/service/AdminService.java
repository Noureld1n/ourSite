package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.AccountUpdateRequestDTO;
import com.smart.ourSite.dto.request.AdminRequestDTO;
import com.smart.ourSite.dto.request.AdminUpdateDTO;
import com.smart.ourSite.dto.response.AccountResponseDTO;
import com.smart.ourSite.dto.response.AdminResponseDTO;
import com.smart.ourSite.model.Admin;
import com.smart.ourSite.repository.AdminRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public List<AdminResponseDTO> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public AdminResponseDTO getAdminById(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return mapToResponseDTO(admin);
    }


    public AdminResponseDTO createAdmin(AdminRequestDTO dto) {
        Admin admin = new Admin();
        mapRequestToEntity(dto, admin);
        return mapToResponseDTO(adminRepository.save(admin));
    }


    public AdminResponseDTO updateAdmin(Long id, AdminRequestDTO dto) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        mapRequestToEntity(dto, admin);
        return mapToResponseDTO(adminRepository.save(admin));
    }


    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found");
        }
        adminRepository.deleteById(id);
    }


    public AccountResponseDTO getProfile(String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

        return new AccountResponseDTO(
                admin.getAdminId(),
                admin.getAdminName(),
                admin.getEmail(),
                admin.getPhoneNumber(),
                admin.getImage()
        );
    }


    public AccountResponseDTO updateProfile(String email, AccountUpdateRequestDTO dto) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

        admin.setAdminName(dto.getAdminName());
        admin.setPhoneNumber(dto.getPhoneNumber());

        // Image upload handling can be added here later if needed
        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            // For now, set a placeholder string
            admin.setImage("uploaded-image-path.png");
        }

        adminRepository.save(admin);

        return new AccountResponseDTO(
                admin.getAdminId(),
                admin.getAdminName(),
                admin.getEmail(),
                admin.getPhoneNumber(),
                admin.getImage()
        );
    }

    public List<AdminResponseDTO> getAdmins(String search) {
        List<Admin> admins;
        if (search == null || search.isEmpty()) {
            admins = adminRepository.findAll();
        } else {
            admins = adminRepository.findByAdminNameContainingIgnoreCase(search);
        }
        return admins.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public String updateAdminFields(Long id, AdminUpdateDTO dto) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setAdminName(dto.getAdminName());
        admin.setImage(dto.getImage());
        admin.setIsActive(dto.getIsActive());
        adminRepository.save(admin);
        return "User updated successfully.";
    }

    public String activateAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setIsActive(true);
        adminRepository.save(admin);
        return "User has been activated successfully.";
    }

    public String deactivateAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setIsActive(false);
        adminRepository.save(admin);
        return "User has been deactivated successfully.";
    }

    public String removeAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found");
        }
        adminRepository.deleteById(id);
        return "User has been deleted successfully.";
    }


    private void mapRequestToEntity(AdminRequestDTO dto, Admin admin) {
        admin.setAdminName(dto.getAdminName());
        admin.setImage(dto.getImage());
        admin.setEmail(dto.getEmail());
        admin.setAdminPassword(dto.getAdminPassword()); // Consider encoding
        admin.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
    }

    private AdminResponseDTO mapToResponseDTO(Admin admin) {
        return new AdminResponseDTO(
                admin.getAdminId(),
                admin.getAdminName(),
                admin.getImage(),
                admin.getEmail(),
                admin.getRegisterDate(),
                admin.getIsActive()
        );
    }
}
