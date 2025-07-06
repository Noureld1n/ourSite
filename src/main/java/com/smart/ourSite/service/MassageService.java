package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.MassageRequestDTO;
import com.smart.ourSite.dto.response.MassageResponseDTO;
import com.smart.ourSite.model.Massage;
import com.smart.ourSite.repository.MassageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MassageService {

    private final MassageRepository massageRepository;

    public MassageService(MassageRepository massageRepository) {
        this.massageRepository = massageRepository;
    }


    public List<MassageResponseDTO> getAllMassages() {
        return massageRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public MassageResponseDTO getMassageById(Long id) {
        Massage massage = massageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Massage not found"));
        return mapToResponseDTO(massage);
    }


    public MassageResponseDTO createMassage(MassageRequestDTO dto) {
        Massage massage = new Massage();
        massage.setFirstName(dto.getFirstName());
        massage.setLastName(dto.getLastName());
        massage.setEmail(dto.getEmail());
        massage.setPhone(dto.getPhone());
        massage.setOrganizationName(dto.getOrganizationName());
        massage.setOrgnizationType(dto.getOrgnizationType());
        massage.setContent(dto.getContent());

        return mapToResponseDTO(massageRepository.save(massage));
    }


    public void deleteMassage(Long id) {
        if (!massageRepository.existsById(id)) {
            throw new RuntimeException("Massage not found");
        }
        massageRepository.deleteById(id);
    }


    public List<MassageResponseDTO> searchMessagesByName(String name) {
        return massageRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private MassageResponseDTO mapToResponseDTO(Massage massage) {
        return new MassageResponseDTO(
                massage.getMassageId(),
                massage.getFirstName(),
                massage.getLastName(),
                massage.getEmail(),
                massage.getPhone(),
                massage.getOrganizationName(),
                massage.getOrgnizationType(),
                massage.getContent(),
                massage.getDateTime()
        );
    }
}
