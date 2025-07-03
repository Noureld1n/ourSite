package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.ApplicationRequestDTO;
import com.smart.ourSite.dto.response.ApplicationResponseDTO;

import java.util.List;

public interface ApplicationService {

    List<ApplicationResponseDTO> getApplicationsByCareerId(Long careerId);

    ApplicationResponseDTO createApplication(ApplicationRequestDTO dto);

    void deleteApplication(Long appId);
}
