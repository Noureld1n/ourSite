package com.smart.ourSite.service.impl;

import com.smart.ourSite.dto.request.CareerRequestDTO;
import com.smart.ourSite.dto.response.CareerResponseDTO;
import com.smart.ourSite.model.Career;
import com.smart.ourSite.repository.CareerRepository;
import com.smart.ourSite.service.CareerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;

    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public List<CareerResponseDTO> getAllCareers() {
        return careerRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CareerResponseDTO getCareerById(Long id) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Career not found"));
        return mapToResponseDTO(career);
    }

    @Override
    public CareerResponseDTO createCareer(CareerRequestDTO dto) {
        Career career = new Career();
        mapRequestToEntity(dto, career);
        return mapToResponseDTO(careerRepository.save(career));
    }

    @Override
    public CareerResponseDTO updateCareer(Long id, CareerRequestDTO dto) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Career not found"));

        mapRequestToEntity(dto, career);
        return mapToResponseDTO(careerRepository.save(career));
    }

    @Override
    public void deleteCareer(Long id) {
        if (!careerRepository.existsById(id)) {
            throw new RuntimeException("Career not found");
        }
        careerRepository.deleteById(id);
    }

    private void mapRequestToEntity(CareerRequestDTO dto, Career career) {
        career.setTitle(dto.getTitle());
        career.setCareerDescription(dto.getCareerDescription());
        career.setCareerType(dto.getCareerType());
        career.setRequirments(dto.getRequirments());
        career.setDeadline(dto.getDeadline());
        career.setSalary(dto.getSalary());
        career.setCommision(dto.getCommision());
        career.setJopTime(dto.getJopTime());
        career.setWorkingDays(dto.getWorkingDays());
        career.setLocation(dto.getLocation());
    }

    private CareerResponseDTO mapToResponseDTO(Career career) {
        return new CareerResponseDTO(
                career.getCareerId(),
                career.getTitle(),
                career.getCareerDescription(),
                career.getCareerType(),
                career.getRequirments(),
                career.getOpenDate(),
                career.getDeadline(),
                career.getSalary(),
                career.getCommision(),
                career.getJopTime(),
                career.getWorkingDays(),
                career.getLocation()
        );
    }
}

