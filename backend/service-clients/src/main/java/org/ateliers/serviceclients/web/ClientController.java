package org.ateliers.serviceclients.web;

import org.ateliers.serviceclients.DTOs.ClientRequestDTO;
import org.ateliers.serviceclients.DTOs.ClientResponseDTO;
import org.ateliers.serviceclients.Services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // 1. GET all clients
    @GetMapping
    public List<ClientResponseDTO> getAllClients() {
        return service.getAllClients();
    }

    // 2. GET client by ID
    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    // 3. POST create new client
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDTO createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        return service.createClient(clientRequestDTO);
    }

    // 4. PUT update client
    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        return service.updateClient(id, clientRequestDTO);
    }

    // 5. DELETE client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
    }
}