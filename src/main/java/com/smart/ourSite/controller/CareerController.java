package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.CareerRequestDTO;
import com.smart.ourSite.dto.response.CareerResponseDTO;
import com.smart.ourSite.service.CareerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/careers")
@RequiredArgsConstructor
public class CareerController {

    private final CareerService careerService;

    @GetMapping
    public ResponseEntity<List<CareerResponseDTO>> getAllCareers() {
        return ResponseEntity.ok(careerService.getAllCareers());
    }

    @PostMapping
    public ResponseEntity<String> createCareer(@Valid @RequestBody CareerRequestDTO dto) {
        careerService.createCareer(dto);
        return ResponseEntity.ok("Career created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCareer(@PathVariable Long id, @Valid @RequestBody CareerRequestDTO dto) {
        careerService.updateCareer(id, dto);
        return ResponseEntity.ok("Career updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCareer(@PathVariable Long id) {
        careerService.deleteCareer(id);
        return ResponseEntity.ok("Career deleted successfully.");
    }
}
