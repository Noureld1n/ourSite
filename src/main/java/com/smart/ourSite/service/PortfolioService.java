package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.PortfolioRequestDTO;
import com.smart.ourSite.dto.response.PortfolioResponseDTO;
import com.smart.ourSite.model.Portfolio;
import com.smart.ourSite.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }


    public List<PortfolioResponseDTO> getAllPortfolios() {
        return portfolioRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public PortfolioResponseDTO getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        return mapToResponseDTO(portfolio);
    }


    public PortfolioResponseDTO createPortfolio(PortfolioRequestDTO dto) {
        Portfolio portfolio = new Portfolio();
        mapRequestToEntity(dto, portfolio);
        return mapToResponseDTO(portfolioRepository.save(portfolio));
    }


    public PortfolioResponseDTO updatePortfolio(Long id, PortfolioRequestDTO dto) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        mapRequestToEntity(dto, portfolio);
        return mapToResponseDTO(portfolioRepository.save(portfolio));
    }


    public void deletePortfolio(Long id) {
        if (!portfolioRepository.existsById(id)) {
            throw new RuntimeException("Portfolio not found");
        }
        portfolioRepository.deleteById(id);
    }

    private void mapRequestToEntity(PortfolioRequestDTO dto, Portfolio portfolio) {
        portfolio.setTitle(dto.getTitle());
        portfolio.setSubtitle(dto.getSubtitle());
        portfolio.setImage(dto.getImage());
        portfolio.setContractDate(dto.getContractDate());
        portfolio.setLogo(dto.getLogo());
    }

    private PortfolioResponseDTO mapToResponseDTO(Portfolio portfolio) {
        return new PortfolioResponseDTO(
                portfolio.getPortfolioId(),
                portfolio.getTitle(),
                portfolio.getSubtitle(),
                portfolio.getImage(),
                portfolio.getLogo(),
                portfolio.getContractDate()

        );
    }
}
