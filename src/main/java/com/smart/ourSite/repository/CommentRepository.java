package com.smart.ourSite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.smart.ourSite.model.*;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlog_BlogId(Long blogId);
}
