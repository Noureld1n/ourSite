package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "career")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long careerId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "career_description", nullable = false, length = 550)
    private String careerDescription;

    @Column(name = "career_type", nullable = false, length = 100)
    private String careerType;

    @Column(nullable = false, length = 1500)
    private String requirments;

    @Column(name = "open_date")
    private LocalDateTime openDate;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false)
    private Integer salary;

    private Integer commision;

    @Column(name = "jop_time", nullable = false, length = 150)
    private String jopTime;

    @Column(name = "working_days", nullable = false, length = 150)
    private String workingDays;

    @Column(nullable = false, length = 250)
    private String location;
}
