package com.smart.ourSite.repository;
import com.smart.ourSite.projection.BlogImageView;
import com.smart.ourSite.model.BlogPart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BlogPartRepository extends JpaRepository<BlogPart, Long> {

    List<BlogPart> findByBlog_BlogId(Long blogId);
    @Query(value = "SELECT image FROM blog_image WHERE blog_part_id = :partId", nativeQuery = true)
    List<String> findImageUrlsByBlogPartId(@Param("partId") Long partId);

    @Query(value = "SELECT image_id AS imageId, image FROM blog_image WHERE blog_part_id = :partId", nativeQuery = true)
    List<BlogImageView> findImageViewsByBlogPartId(@Param("partId") Long partId);
}

