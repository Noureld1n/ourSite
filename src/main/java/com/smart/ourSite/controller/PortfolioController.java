package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.PortfolioRequestDTO;
import com.smart.ourSite.dto.response.PortfolioResponseDTO;
import com.smart.ourSite.model.Portfolio;
import com.smart.ourSite.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/portfolio")
@RequiredArgsConstructor
@Slf4j
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;

    @GetMapping
    public ResponseEntity<List<PortfolioResponseDTO>> getAllPortfolios() {
        List<PortfolioResponseDTO> portfolios = portfolioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(portfolios);
    }

    @PostMapping
    public ResponseEntity<?> createPortfolio(@RequestBody PortfolioRequestDTO dto) {
        if (dto.getTitle() == null || dto.getContractDate() == null) {
            return ResponseEntity.badRequest().body("Title and contractDate are required.");
        }

        Portfolio portfolio = toEntity(dto);
        portfolioRepository.save(portfolio);
        return ResponseEntity.ok("Portfolio project added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePortfolio(@PathVariable Long id, @RequestBody PortfolioRequestDTO dto) {
        return portfolioRepository.findById(id).map(existing -> {
            existing.setTitle(dto.getTitle());
            existing.setSubtitle(dto.getSubtitle());
            existing.setImage(dto.getImage());
            existing.setContractDate(dto.getContractDate());
            existing.setLogo(dto.getLogo());
            portfolioRepository.save(existing);
            return ResponseEntity.ok("Portfolio project updated successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        return portfolioRepository.findById(id).map(existing -> {
            portfolioRepository.delete(existing);
            return ResponseEntity.ok("Portfolio project deleted successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    private PortfolioResponseDTO toResponseDTO(Portfolio p) {
        PortfolioResponseDTO dto = new PortfolioResponseDTO();
        dto.setPortfolioId(p.getPortfolioId());
        dto.setTitle(p.getTitle());
        dto.setSubtitle(p.getSubtitle());
        dto.setImage(p.getImage());
        dto.setContractDate(p.getContractDate());
        dto.setLogo(p.getLogo());
        return dto;
    }

    private Portfolio toEntity(PortfolioRequestDTO dto) {
        Portfolio p = new Portfolio();
        p.setTitle(dto.getTitle());
        p.setSubtitle(dto.getSubtitle());
        p.setImage(dto.getImage());
        p.setContractDate(dto.getContractDate());
        p.setLogo(dto.getLogo());
        return p;
    }
}
