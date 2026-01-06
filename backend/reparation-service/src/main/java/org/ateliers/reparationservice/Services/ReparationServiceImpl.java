package org.ateliers.reparationservice.Services;

import org.ateliers.reparationservice.DTOs.ReparationRequestDTO;
import org.ateliers.reparationservice.DTOs.ReparationResponseDTO;
import org.ateliers.reparationservice.Entity.Reparation;
import org.ateliers.reparationservice.Mappers.ReparationMapper;
import org.ateliers.reparationservice.Repos.ReparationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparationServiceImpl implements ReparationService {

    private final ReparationRepository repository;

    public ReparationServiceImpl(ReparationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReparationResponseDTO> getAllReparations() {
        return repository.findAll()
                .stream()
                .map(ReparationMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<ReparationResponseDTO> getReparationById(Long id) {
        return repository.findById(id)
                .map(ReparationMapper::toDTO);
    }

    @Override
    public ReparationResponseDTO createReparation(ReparationRequestDTO requestDTO) {
        Reparation reparation = ReparationMapper.toEntity(requestDTO);
        Reparation saved = repository.save(reparation);
        return ReparationMapper.toDTO(saved);
    }

    @Override
    public Optional<ReparationResponseDTO> updateReparation(Long id, ReparationRequestDTO requestDTO) {
        Optional<Reparation> existing = repository.findById(id);
        if (existing.isPresent()) {
            Reparation reparation = existing.get();
            ReparationMapper.updateEntityFromDTO(requestDTO, reparation);
            repository.save(reparation);
            return Optional.of(ReparationMapper.toDTO(reparation));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteReparation(Long id) {
        return repository.deleteById(id);
    }
}