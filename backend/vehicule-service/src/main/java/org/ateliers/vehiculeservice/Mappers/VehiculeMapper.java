package org.ateliers.vehiculeservice.Mappers;

import org.ateliers.vehiculeservice.DTOs.VehiculeRequestDTO;
import org.ateliers.vehiculeservice.DTOs.VehiculeResponseDTO;
import org.ateliers.vehiculeservice.Entity.Vehicule;

public class VehiculeMapper {

    public static VehiculeResponseDTO toDTO(Vehicule vehicule) {
        return new VehiculeResponseDTO(
                vehicule.getId(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getClientId()
        );
    }

    public static Vehicule toEntity(VehiculeRequestDTO dto) {
        Vehicule vehicule = new Vehicule();
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setClientId(dto.getClientId());
        return vehicule;
    }

    public static void updateEntityFromDTO(VehiculeRequestDTO dto, Vehicule vehicule) {
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setClientId(dto.getClientId());
    }
}