package org.ateliers.serviceclients.DTOs;

public class ClientResponseDTO {
    private Long id;
    private String nom;
    private String contact;

    public ClientResponseDTO(Long id, String nom, String contact) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getContact() { return contact; }
}
