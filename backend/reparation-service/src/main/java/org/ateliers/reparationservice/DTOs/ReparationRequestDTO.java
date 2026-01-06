package org.ateliers.reparationservice.DTOs;

import java.time.LocalDate;

public class ReparationRequestDTO {
    private Long vehiculeId;
    private String description;
    private LocalDate date;

    public Long getVehiculeId() { return vehiculeId; }
    public void setVehiculeId(Long vehiculeId) { this.vehiculeId = vehiculeId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}