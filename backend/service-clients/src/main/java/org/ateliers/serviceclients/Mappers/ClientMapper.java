package org.ateliers.serviceclients.Mappers;

import org.ateliers.serviceclients.DTOs.ClientResponseDTO;
import org.ateliers.serviceclients.Entity.Client;

public class ClientMapper {

    public static ClientResponseDTO toDTO(Client client) {
        if (client == null) return null;

        return new ClientResponseDTO(
                client.getId(),
                client.getNom(),
                client.getContact()
        );
    }
}