package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 150)
    private String subtitle;

    @Column(length = 50)
    private String tag;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(name = "publish_date")
    private LocalDateTime publishDate;

    @Column(name = "main_image", nullable = false, length = 255)
    private String mainImage;
}

