package org.ateliers.reparationservice.Mappers;

import org.ateliers.reparationservice.DTOs.ReparationRequestDTO;
import org.ateliers.reparationservice.DTOs.ReparationResponseDTO;
import org.ateliers.reparationservice.Entity.Reparation;

public class ReparationMapper {

    public static ReparationResponseDTO toDTO(Reparation r) {
        return new ReparationResponseDTO(
                r.getId(),
                r.getVehiculeId(),
                r.getDescription(),
                r.getDate()
        );
    }

    public static Reparation toEntity(ReparationRequestDTO dto) {
        Reparation reparation = new Reparation();
        reparation.setVehiculeId(dto.getVehiculeId());
        reparation.setDescription(dto.getDescription());
        reparation.setDate(dto.getDate());
        return reparation;
    }

    public static void updateEntityFromDTO(ReparationRequestDTO dto, Reparation reparation) {
        reparation.setVehiculeId(dto.getVehiculeId());
        reparation.setDescription(dto.getDescription());
        reparation.setDate(dto.getDate());
    }
}