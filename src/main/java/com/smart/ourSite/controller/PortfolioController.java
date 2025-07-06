package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.PortfolioRequestDTO;
import com.smart.ourSite.dto.response.PortfolioResponseDTO;
import com.smart.ourSite.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<PortfolioResponseDTO>> getAllPortfolios() {
        return ResponseEntity.ok(portfolioService.getAllPortfolios());
    }

    @PostMapping
    public ResponseEntity<PortfolioResponseDTO> createPortfolio(@Valid @RequestBody PortfolioRequestDTO dto) {
        return ResponseEntity.ok(portfolioService.createPortfolio(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioResponseDTO> updatePortfolio(
            @PathVariable Long id,
            @Valid @RequestBody PortfolioRequestDTO dto
    ) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return ResponseEntity.ok("Portfolio project deleted successfully");
    }
}
