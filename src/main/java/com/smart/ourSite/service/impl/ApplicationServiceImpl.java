package com.smart.ourSite.service.impl;

import com.smart.ourSite.dto.request.ApplicationRequestDTO;
import com.smart.ourSite.dto.response.ApplicationResponseDTO;
import com.smart.ourSite.model.Application;
import com.smart.ourSite.model.Career;
import com.smart.ourSite.repository.ApplicationRepository;
import com.smart.ourSite.repository.CareerRepository;
import com.smart.ourSite.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CareerRepository careerRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, CareerRepository careerRepository) {
        this.applicationRepository = applicationRepository;
        this.careerRepository = careerRepository;
    }

    @Override
    public List<ApplicationResponseDTO> getApplicationsByCareerId(Long careerId) {
        return applicationRepository.findByCareer_CareerId(careerId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationResponseDTO createApplication(ApplicationRequestDTO dto) {
        Career career = careerRepository.findById(dto.getCareerId())
                .orElseThrow(() -> new RuntimeException("Career not found"));

        Application application = new Application();
        application.setAppName(dto.getAppName());
        application.setImage(dto.getImage());
        application.setEmail(dto.getEmail());
        application.setPhone(dto.getPhone());
        application.setAppDescription(dto.getAppDescription());
        application.setAppResume(dto.getAppResume());
        application.setCareer(career);

        return mapToResponseDTO(applicationRepository.save(application));
    }

    @Override
    public void deleteApplication(Long appId) {
        if (!applicationRepository.existsById(appId)) {
            throw new RuntimeException("Application not found");
        }
        applicationRepository.deleteById(appId);
    }

    private ApplicationResponseDTO mapToResponseDTO(Application application) {
        return new ApplicationResponseDTO(
                application.getAppId(),
                application.getAppName(),
                application.getImage(),
                application.getEmail(),
                application.getPhone(),
                application.getAppDescription(),
                application.getAppResume(),
                application.getCareer().getCareerId()
        );
    }
}
