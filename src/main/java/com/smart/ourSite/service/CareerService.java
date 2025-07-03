package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.CareerRequestDTO;
import com.smart.ourSite.dto.response.CareerResponseDTO;

import java.util.List;

public interface CareerService {

    List<CareerResponseDTO> getAllCareers();

    CareerResponseDTO getCareerById(Long id);

    CareerResponseDTO createCareer(CareerRequestDTO dto);

    CareerResponseDTO updateCareer(Long id, CareerRequestDTO dto);

    void deleteCareer(Long id);
}
