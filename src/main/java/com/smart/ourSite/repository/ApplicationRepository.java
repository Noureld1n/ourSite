package com.smart.ourSite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.smart.ourSite.model.*;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByCareer_CareerId(Long careerId);
}
