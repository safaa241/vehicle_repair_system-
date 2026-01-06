package org.ateliers.serviceclients.Services;

import org.ateliers.serviceclients.DTOs.ClientRequestDTO;
import org.ateliers.serviceclients.DTOs.ClientResponseDTO;
import java.util.List;

public interface ClientService {
    // 1. GET all
    List<ClientResponseDTO> getAllClients();

    // 2. GET by ID
    ClientResponseDTO getClientById(Long id);

    // 3. POST create
    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO);

    // 4. PUT update
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);

    // 5. DELETE
    void deleteClient(Long id);
}