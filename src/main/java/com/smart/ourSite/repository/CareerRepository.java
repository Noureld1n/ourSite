package com.smart.ourSite.repository;
import com.smart.ourSite.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {

    List<Career> findByCareerType(String careerType);

    List<Career> findByDeadlineAfter(java.time.LocalDateTime now);
}

