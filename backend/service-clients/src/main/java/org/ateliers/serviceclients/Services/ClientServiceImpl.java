package org.ateliers.serviceclients.Services;

import org.ateliers.serviceclients.DTOs.ClientRequestDTO;
import org.ateliers.serviceclients.DTOs.ClientResponseDTO;
import org.ateliers.serviceclients.Entity.Client;
import org.ateliers.serviceclients.Exceptions.ClientNotFoundException;
import org.ateliers.serviceclients.Mappers.ClientMapper;
import org.ateliers.serviceclients.Repos.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        return repository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .toList();
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé avec l'ID: " + id));
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client client = new Client(null, clientRequestDTO.getNom(), clientRequestDTO.getContact());
        Client savedClient = repository.save(client);
        return ClientMapper.toDTO(savedClient);
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client existingClient = repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé avec l'ID: " + id));

        // Met à jour les champs
        Client updatedClient = new Client(
                id,
                clientRequestDTO.getNom() != null ? clientRequestDTO.getNom() : existingClient.getNom(),
                clientRequestDTO.getContact() != null ? clientRequestDTO.getContact() : existingClient.getContact()
        );

        Client savedClient = repository.save(updatedClient);
        return ClientMapper.toDTO(savedClient);
    }

    @Override
    public void deleteClient(Long id) {
        if (!repository.existsById(id)) {
            throw new ClientNotFoundException("Client non trouvé avec l'ID: " + id);
        }
        repository.deleteById(id);
    }
}