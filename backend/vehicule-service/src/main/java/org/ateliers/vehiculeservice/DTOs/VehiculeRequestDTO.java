package org.ateliers.vehiculeservice.DTOs;

public class VehiculeRequestDTO {
    private String marque;
    private String modele;
    private Long clientId;

    // Getters et Setters
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}