package org.ateliers.vehiculeservice.Services;

import org.ateliers.vehiculeservice.DTOs.VehiculeRequestDTO;
import org.ateliers.vehiculeservice.DTOs.VehiculeResponseDTO;
import org.ateliers.vehiculeservice.Entity.Vehicule;
import org.ateliers.vehiculeservice.Mappers.VehiculeMapper;
import org.ateliers.vehiculeservice.Repos.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository repository;

    public VehiculeServiceImpl(VehiculeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VehiculeResponseDTO> getAllVehicules() {
        return repository.findAll()
                .stream()
                .map(VehiculeMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<VehiculeResponseDTO> getVehiculeById(Long id) {
        return repository.findById(id)
                .map(VehiculeMapper::toDTO);
    }

    @Override
    public VehiculeResponseDTO createVehicule(VehiculeRequestDTO requestDTO) {
        Vehicule vehicule = VehiculeMapper.toEntity(requestDTO);
        Vehicule saved = repository.save(vehicule);
        return VehiculeMapper.toDTO(saved);
    }

    @Override
    public Optional<VehiculeResponseDTO> updateVehicule(Long id, VehiculeRequestDTO requestDTO) {
        Optional<Vehicule> existing = repository.findById(id);
        if (existing.isPresent()) {
            Vehicule vehicule = existing.get();
            VehiculeMapper.updateEntityFromDTO(requestDTO, vehicule);
            repository.save(vehicule);
            return Optional.of(VehiculeMapper.toDTO(vehicule));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteVehicule(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public List<VehiculeResponseDTO> getVehiculesByClientId(Long clientId) {
        return repository.findByClientId(clientId)
                .stream()
                .map(VehiculeMapper::toDTO)
                .toList();
    }
}