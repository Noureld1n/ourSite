package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "team_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_name", nullable = false, length = 100)
    private String memberName;

    @Column(name = "member_role", nullable = false, length = 50)
    private String memberRole;

    @Column(nullable = false, length = 225)
    private String image;
}