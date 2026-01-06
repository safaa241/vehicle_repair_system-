package org.ateliers.reparationservice.Entity;

import java.time.LocalDate;

public class Reparation {
    private Long id;
    private Long vehiculeId;
    private String description;
    private LocalDate date;

    public Reparation() {}

    public Reparation(Long id, Long vehiculeId, String description, LocalDate date) {
        this.id = id;
        this.vehiculeId = vehiculeId;
        this.description = description;
        this.date = date;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVehiculeId() { return vehiculeId; }
    public void setVehiculeId(Long vehiculeId) { this.vehiculeId = vehiculeId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}