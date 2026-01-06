package org.ateliers.reparationservice.Services;

import org.ateliers.reparationservice.DTOs.ReparationRequestDTO;
import org.ateliers.reparationservice.DTOs.ReparationResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ReparationService {
    List<ReparationResponseDTO> getAllReparations();
    Optional<ReparationResponseDTO> getReparationById(Long id);
    ReparationResponseDTO createReparation(ReparationRequestDTO requestDTO);
    Optional<ReparationResponseDTO> updateReparation(Long id, ReparationRequestDTO requestDTO);
    boolean deleteReparation(Long id);
}