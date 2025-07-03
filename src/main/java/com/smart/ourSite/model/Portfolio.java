package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "portfolio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 150)
    private String subtitle;

    @Column(nullable = false, length = 225)
    private String image;

    @Column(name = "contract_date", nullable = false)
    private LocalDateTime contractDate;

    @Column(length = 225)
    private String logo;


}
