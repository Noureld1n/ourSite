package com.smart.ourSite.model;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "comment_text", nullable = false, length = 1500)
    private String commentText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", nullable = false, foreignKey = @ForeignKey(name = "COMMENT_FK"))
    private Blog blog;
}

