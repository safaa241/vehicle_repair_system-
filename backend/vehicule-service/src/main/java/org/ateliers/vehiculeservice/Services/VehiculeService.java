package org.ateliers.vehiculeservice.Services;

import org.ateliers.vehiculeservice.DTOs.VehiculeRequestDTO;
import org.ateliers.vehiculeservice.DTOs.VehiculeResponseDTO;

import java.util.List;
import java.util.Optional;

public interface VehiculeService {
    List<VehiculeResponseDTO> getAllVehicules();
    Optional<VehiculeResponseDTO> getVehiculeById(Long id);
    VehiculeResponseDTO createVehicule(VehiculeRequestDTO requestDTO);
    Optional<VehiculeResponseDTO> updateVehicule(Long id, VehiculeRequestDTO requestDTO);
    boolean deleteVehicule(Long id);
    List<VehiculeResponseDTO> getVehiculesByClientId(Long clientId);
}