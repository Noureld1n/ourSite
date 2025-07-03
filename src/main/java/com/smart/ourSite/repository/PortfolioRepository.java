package com.smart.ourSite.repository;
import com.smart.ourSite.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByTitleContainingIgnoreCase(String keyword);
    List<Portfolio> findBySubtitleContainingIgnoreCase(String keyword);
}

