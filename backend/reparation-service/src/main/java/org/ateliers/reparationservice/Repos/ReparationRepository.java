package org.ateliers.reparationservice.Repos;

import org.ateliers.reparationservice.Entity.Reparation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReparationRepository {

    private final List<Reparation> reparations = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(3L); // Commence après les données initiales

    public ReparationRepository() {
        reparations.add(
                new Reparation(1L, 1L, "Vidange", LocalDate.now())
        );
        reparations.add(
                new Reparation(2L, 2L, "Changement freins", LocalDate.now().minusDays(2))
        );
    }

    // 🔹 READ ALL
    public List<Reparation> findAll() {
        return new ArrayList<>(reparations);
    }

    // 🔹 READ BY ID
    public Optional<Reparation> findById(Long id) {
        return reparations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    // 🔹 CREATE
    public Reparation save(Reparation reparation) {
        if (reparation.getId() == null) {
            reparation.setId(idCounter.getAndIncrement());
        } else {
            deleteById(reparation.getId());
        }
        reparations.add(reparation);
        return reparation;
    }

    // 🔹 UPDATE
    public Optional<Reparation> update(Long id, Reparation reparation) {
        Optional<Reparation> existing = findById(id);
        if (existing.isPresent()) {
            Reparation toUpdate = existing.get();
            toUpdate.setVehiculeId(reparation.getVehiculeId());
            toUpdate.setDescription(reparation.getDescription());
            toUpdate.setDate(reparation.getDate());
            return Optional.of(toUpdate);
        }
        return Optional.empty();
    }

    // 🔹 DELETE
    public boolean deleteById(Long id) {
        return reparations.removeIf(r -> r.getId().equals(id));
    }
}