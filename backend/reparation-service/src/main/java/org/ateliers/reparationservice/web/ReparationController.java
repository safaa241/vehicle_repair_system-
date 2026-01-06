package org.ateliers.reparationservice.web;

import org.ateliers.reparationservice.DTOs.ReparationRequestDTO;
import org.ateliers.reparationservice.DTOs.ReparationResponseDTO;
import org.ateliers.reparationservice.Services.ReparationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reparations")
public class ReparationController {

    private final ReparationService service;

    public ReparationController(ReparationService service) {
        this.service = service;
    }

    // 1. GET ALL
    @GetMapping
    public List<ReparationResponseDTO> getAllReparations() {
        return service.getAllReparations();
    }

    // 2. GET BY ID - À AJOUTER
    @GetMapping("/{id}")
    public ResponseEntity<ReparationResponseDTO> getReparationById(@PathVariable Long id) {
        return service.getReparationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST CREATE - À AJOUTER
    @PostMapping
    public ResponseEntity<ReparationResponseDTO> createReparation(@RequestBody ReparationRequestDTO requestDTO) {
        ReparationResponseDTO created = service.createReparation(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 4. PUT UPDATE - À AJOUTER
    @PutMapping("/{id}")
    public ResponseEntity<ReparationResponseDTO> updateReparation(
            @PathVariable Long id,
            @RequestBody ReparationRequestDTO requestDTO) {
        return service.updateReparation(id, requestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE - À AJOUTER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReparation(@PathVariable Long id) {
        boolean deleted = service.deleteReparation(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}