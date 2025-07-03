package com.smart.ourSite.repository;
import com.smart.ourSite.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    // 🔁 Find admin by email (e.g. for login)
    Optional<Admin> findByEmail(String email);
    List<Admin> findByAdminNameContainingIgnoreCase(String search);

}
