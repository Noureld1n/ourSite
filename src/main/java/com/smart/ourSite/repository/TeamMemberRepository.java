package com.smart.ourSite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.smart.ourSite.model.*;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    List<TeamMember> findByMemberRole(String memberRole);
}

