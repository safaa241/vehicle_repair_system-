package org.ateliers.vehiculeservice.web;

import org.ateliers.vehiculeservice.DTOs.VehiculeRequestDTO;
import org.ateliers.vehiculeservice.DTOs.VehiculeResponseDTO;
import org.ateliers.vehiculeservice.Services.VehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeService service;

    public VehiculeController(VehiculeService service) {
        this.service = service;
    }

    // 1. GET ALL - Existe déjà
    @GetMapping
    public List<VehiculeResponseDTO> getAllVehicules() {
        return service.getAllVehicules();
    }

    // 2. GET BY ID - À AJOUTER
    @GetMapping("/{id}")
    public ResponseEntity<VehiculeResponseDTO> getVehiculeById(@PathVariable Long id) {
        return service.getVehiculeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. GET BY CLIENT ID - À AJOUTER
    @GetMapping("/client/{clientId}")
    public List<VehiculeResponseDTO> getVehiculesByClientId(@PathVariable Long clientId) {
        return service.getVehiculesByClientId(clientId);
    }

    // 4. POST CREATE - À AJOUTER
    @PostMapping
    public ResponseEntity<VehiculeResponseDTO> createVehicule(@RequestBody VehiculeRequestDTO requestDTO) {
        VehiculeResponseDTO created = service.createVehicule(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 5. PUT UPDATE - À AJOUTER
    @PutMapping("/{id}")
    public ResponseEntity<VehiculeResponseDTO> updateVehicule(
            @PathVariable Long id,
            @RequestBody VehiculeRequestDTO requestDTO) {
        return service.updateVehicule(id, requestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 6. DELETE - À AJOUTER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        boolean deleted = service.deleteVehicule(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}