package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long appId;

    @Column(name = "app_name", nullable = false, length = 150)
    private String appName;

    @Column(nullable = false, length = 255)
    private String image;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String phone;

    @Column(name = "app_description", nullable = false, length = 2500)
    private String appDescription;

    @Column(name = "app_resume", nullable = false, length = 225)
    private String appResume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "career_id", nullable = false, foreignKey = @ForeignKey(name = "APPLICATION_FK"))
    private Career career;
}

