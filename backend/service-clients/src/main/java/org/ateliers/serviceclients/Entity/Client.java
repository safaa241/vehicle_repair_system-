package org.ateliers.serviceclients.Entity;

public class Client {
    private Long id;
    private String nom;
    private String contact;

    public Client(Long id, String nom, String contact) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
    }

    // Getters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getContact() { return contact; }

    // SETTERS (CRITIQUES - AJOUTE CES 3 MÉTHODES)
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setContact(String contact) { this.contact = contact; }
}