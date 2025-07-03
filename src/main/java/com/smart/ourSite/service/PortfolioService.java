package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.PortfolioRequestDTO;
import com.smart.ourSite.dto.response.PortfolioResponseDTO;

import java.util.List;

public interface PortfolioService {

    List<PortfolioResponseDTO> getAllPortfolios();

    PortfolioResponseDTO getPortfolioById(Long id);

    PortfolioResponseDTO createPortfolio(PortfolioRequestDTO dto);

    PortfolioResponseDTO updatePortfolio(Long id, PortfolioRequestDTO dto);

    void deletePortfolio(Long id);
}
