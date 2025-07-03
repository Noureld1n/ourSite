package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "blog_part")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_part_id")
    private Long blogPartId;

    @Column(name = "blog_number", nullable = false)
    private Integer blogNumber;

    @Column(name = "blog_text", nullable = false, length = 4000)
    private String blogText;

    @Column(name = "blog_type", nullable = false, length = 100)
    private String blogType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false, foreignKey = @ForeignKey(name = "BLOG_PART_FK"))
    private Blog blog;
}

