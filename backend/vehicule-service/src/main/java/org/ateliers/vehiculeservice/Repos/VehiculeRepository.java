package org.ateliers.vehiculeservice.Repos;

import org.ateliers.vehiculeservice.Entity.Vehicule;
import org.ateliers.vehiculeservice.Exceptions.VehiculeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VehiculeRepository {

    private final List<Vehicule> vehicules = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(3L); // Commence après les données initiales

    public VehiculeRepository() {
        vehicules.add(new Vehicule(1L, "Toyota", "Yaris", 1L));
        vehicules.add(new Vehicule(2L, "Dacia", "Logan", 2L));
    }

    // 🔹 READ ALL
    public List<Vehicule> findAll() {
        return new ArrayList<>(vehicules);
    }

    // 🔹 READ BY ID
    public Optional<Vehicule> findById(Long id) {
        return vehicules.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    // 🔹 CREATE
    public Vehicule save(Vehicule vehicule) {
        if (vehicule.getId() == null) {
            vehicule.setId(idCounter.getAndIncrement());
        } else {
            deleteById(vehicule.getId());
        }
        vehicules.add(vehicule);
        return vehicule;
    }

    // 🔹 UPDATE
    public Optional<Vehicule> update(Long id, Vehicule vehicule) {
        Optional<Vehicule> existing = findById(id);
        if (existing.isPresent()) {
            Vehicule toUpdate = existing.get();
            toUpdate.setMarque(vehicule.getMarque());
            toUpdate.setModele(vehicule.getModele());
            toUpdate.setClientId(vehicule.getClientId());
            return Optional.of(toUpdate);
        }
        return Optional.empty();
    }

    // 🔹 DELETE
    public boolean deleteById(Long id) {
        return vehicules.removeIf(v -> v.getId().equals(id));
    }

    // 🔹 FIND BY CLIENT ID
    public List<Vehicule> findByClientId(Long clientId) {
        return vehicules.stream()
                .filter(v -> v.getClientId().equals(clientId))
                .toList();
    }
}