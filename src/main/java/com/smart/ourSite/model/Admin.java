package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sys_admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_name", nullable = false, length = 150)
    private String adminName;

    @Column(nullable = false, length = 225)
    private String image;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "admin_password", nullable = false, length = 100)
    private String adminPassword;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "is_active")
    private Boolean isActive;
}

