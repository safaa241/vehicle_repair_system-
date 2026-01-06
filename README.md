# Vehicle Repair Management System

## Système de Gestion des Réparations de Véhicules – Architecture Microservices, Spring Boot, Spring Cloud & Docker

##  Présentation du projet

Le **Vehicle Repair Management System** est une application backend basée sur une **architecture microservices**, conçue pour gérer **la gestion des clients, véhicules et réparations** dans un atelier de réparation automobile.

Chaque domaine métier est isolé dans un microservice indépendant, permettant :

* la **modularité**,
* la **scalabilité**,
* la **maintenance simplifiée**.

L’application repose sur :

* **Spring Boot** pour le développement des microservices
* **Spring Cloud Eureka** pour le Service Discovery
* **Spring Cloud Gateway** pour le routage via un point d’accès unique
* **Docker** et **Docker Compose** pour la conteneurisation et l’orchestration


##  Objectifs du projet

* Mettre en œuvre une **architecture microservices complète**
* Séparer les responsabilités métiers (clients, véhicules, réparations)
* Implémenter un **Service Discovery** centralisé via Eureka
* Centraliser les appels via une **API Gateway**
* Déployer tous les microservices avec **Docker Compose**
* Tester toutes les fonctionnalités avec **Postman**


##  Architecture générale détaillée

```
vehicle-repair-system
│
├── eureka-server            # Service de découverte des microservices
├── api-gateway              # API Gateway centralisée
├── client-service           # Gestion des clients
├── vehicule-service         # Gestion des véhicules
├── reparation-service       # Gestion des réparations
│
└── docker-compose.yml       # Orchestration des services
```

###  Détails

1. **Eureka Server**

   * Rôle : Service Discovery
   * Tous les microservices s’y enregistrent automatiquement
   * Port exposé : `8761`
   * URL : `http://localhost:8761`

2. **API Gateway**

   * Point d’entrée unique pour tous les clients externes
   * Redirige les requêtes vers les services appropriés
   * Gestion de la sécurité, routage et load balancing
   * Port exposé : `8899`

3. **Client Service**

   * CRUD complet sur les clients
   * Gère les informations personnelles et coordonnées
   * URL via Gateway : `/clients/**`

4. **Véhicule Service**

   * CRUD complet sur les véhicules
   * Chaque véhicule est lié à un client
   * URL via Gateway : `/vehicules/**`

5. **Réparation Service**

   * CRUD complet sur les réparations
   * Chaque réparation est liée à un véhicule
   * URL via Gateway : `/reparations/**`



##  Technologies utilisées

| Technologie             | Utilisation                      |
| ----------------------- | -------------------------------- |
| Java 17                 | Langage                          |
| Spring Boot             | Microservices                    |
| Spring Data JPA         | Persistance des données          |
| Spring Cloud Eureka     | Service Discovery                |
| Spring Cloud Gateway    | API Gateway / Routage            |
| Maven                   | Gestion de projet & build        |
| Docker & Docker Compose | Conteneurisation & orchestration |
| REST / JSON             | Communication entre services     |
| Postman                 | Tests API                        |


##  Tests complets avec Postman

 **Base URL**

```
http://localhost:8899
```

Chaque test est effectué via l’API Gateway.


### 🔹 Client Service

1️⃣ **Créer un client**

* Méthode : POST
* URL : `/clients`
* Body JSON :

```json
{
  "nom": "Ahmed Benali",
  "contact": "0666778899"
}
```

2️⃣ **Lister tous les clients**

* Méthode : GET
* URL : `/clients`

3️⃣ **Récupérer un client par ID**

* Méthode : GET
* URL : `/clients/{id}`

4️⃣ **Modifier un client**

* Méthode : PUT
* URL : `/clients/{id}`
* Body JSON :

```json
{
  "nom": "Ahmed Modifié",
  "contact": "0612345678"
}
```

5️⃣ **Supprimer un client**

* Méthode : DELETE
* URL : `/clients/{id}`


### 🔹 Véhicule Service

6️⃣ **Créer un véhicule**

* Méthode : POST
* URL : `/vehicules`
* Body JSON :

```json
{
  "marque": "Toyota",
  "modele": "Corolla",
  "clientId": 1
}
```

7️⃣ **Lister tous les véhicules**

* Méthode : GET
* URL : `/vehicules`

8️⃣ **Récupérer un véhicule par ID**

* Méthode : GET
* URL : `/vehicules/{id}`

9️⃣ **Lister les véhicules d’un client**

* Méthode : GET
* URL : `/vehicules/client/{clientId}`

🔟 **Supprimer un véhicule**

* Méthode : DELETE
* URL : `/vehicules/{id}`


###  Réparation Service

1️⃣1️⃣ **Créer une réparation**

* Méthode : POST
* URL : `/reparations`
* Body JSON :

```json
{
  "vehiculeId": 1,
  "description": "Changement de freins",
  "date": "2025-01-10"
}
```

1️⃣2️⃣ **Lister toutes les réparations**

* Méthode : GET
* URL : `/reparations`

1️⃣3️⃣ **Récupérer une réparation par ID**

* Méthode : GET
* URL : `/reparations/{id}`

1️⃣4️⃣ **Lister les réparations d’un véhicule**

* Méthode : GET
* URL : `/reparations/vehicule/{vehiculeId}`

1️⃣5️⃣ **Supprimer une réparation**

* Méthode : DELETE
* URL : `/reparations/{id}`


##  Accès aux services

| Composant     | URL                                            |
| ------------- | ---------------------------------------------- |
| Eureka Server | [http://localhost:8761](http://localhost:8761) |
| API Gateway   | [http://localhost:8899](http://localhost:8899) |


##  Déploiement avec Docker

L’ensemble du système est lancé avec la commande :

```bash
docker compose up --build
```

Chaque microservice est exécuté dans un **conteneur Docker** sur un **réseau commun**.




* **Réalisé par :** FEKNI Safaa & BACHRI Fatima Ezzahra
* **Projet :** Vehicle Repair Management System
* **Technologies :** Java – Spring Boot – Docker
* **Module :** Développement dans le Cloud & Microservices<
* **Année Universitaire :** 2025-2026
* **Encadré par :** Mr: HABIB Ayad


