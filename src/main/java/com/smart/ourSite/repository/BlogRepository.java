package com.smart.ourSite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smart.ourSite.model.*;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
