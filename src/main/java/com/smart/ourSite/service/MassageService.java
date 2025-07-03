package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.MassageRequestDTO;
import com.smart.ourSite.dto.response.MassageResponseDTO;

import java.util.List;

public interface MassageService {

    List<MassageResponseDTO> getAllMassages();

    MassageResponseDTO getMassageById(Long id);

    MassageResponseDTO createMassage(MassageRequestDTO dto);
    List<MassageResponseDTO> searchMessagesByName(String name);

    void deleteMassage(Long id);
}
