package com.smart.ourSite.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "massage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Massage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "massage_id")
    private Long massageId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 50)
    private String phone;

    @Column(name = "organization_name", nullable = false, length = 50)
    private String organizationName;

    @Column(name = "orgnization_type", nullable = false, length = 50)
    private String orgnizationType;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}

