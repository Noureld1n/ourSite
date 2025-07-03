package com.smart.ourSite.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.smart.ourSite.model.*;

public interface MassageRepository extends JpaRepository<Massage, Long> {

    List<Massage> findByOrgnizationType(String orgnizationType);
    List<Massage> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}

