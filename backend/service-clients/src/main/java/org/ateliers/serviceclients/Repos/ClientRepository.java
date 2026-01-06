package org.ateliers.serviceclients.Repos;

import org.ateliers.serviceclients.Entity.Client;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientRepository {

    // IMPORTANT: static pour persister entre les appels
    private static final List<Client> clients = new ArrayList<>();
    private static final AtomicLong nextId = new AtomicLong(3L); // Commence après les 2 initiaux

    // Bloc static pour initialisation UNE FOIS
    static {
        clients.add(new Client(1L, "Aya", "0600000000"));
        clients.add(new Client(2L, "Omar", "0700000000"));
        System.out.println("✅ Repository initialisé avec " + clients.size() + " clients");
    }

    public List<Client> findAll() {
        System.out.println("📋 GET ALL - Nombre de clients: " + clients.size());
        return new ArrayList<>(clients); // Retourne une copie
    }

    public Optional<Client> findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    public Client save(Client client) {
        if (client.getId() == null) {
            // NOUVEAU CLIENT
            Long newId = nextId.getAndIncrement();
            client.setId(newId);
            clients.add(client);
            System.out.println("✅ POST - Client ajouté: " + client.getNom() + " (ID: " + newId + ")");
            System.out.println("📊 Total clients après ajout: " + clients.size());
        } else {
            // MISE À JOUR
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId().equals(client.getId())) {
                    clients.set(i, client);
                    System.out.println("✅ PUT - Client mis à jour (ID: " + client.getId() + ")");
                    break;
                }
            }
        }
        return client;
    }

    public void deleteById(Long id) {
        boolean removed = clients.removeIf(client -> client.getId().equals(id));
        if (removed) {
            System.out.println("✅ DELETE - Client supprimé (ID: " + id + ")");
            System.out.println("📊 Total clients après suppression: " + clients.size());
        }
    }

    public boolean existsById(Long id) {
        return clients.stream().anyMatch(client -> client.getId().equals(id));
    }
}