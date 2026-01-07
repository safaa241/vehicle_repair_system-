# Vehicle Repair Management System - Solution Full Stack

## Vue d'ensemble du Projet

Le **Vehicle Repair Management System** est une application complète de gestion d'atelier automobile développée avec une architecture microservices moderne pour le backend et une interface utilisateur réactive en React.js pour le frontend. Cette solution permet une gestion centralisée et efficace des opérations d'un atelier de réparation automobile.

## Architecture Technique

### **Backend - Écosystème Microservices**
- **Eureka Server** (port 8761) : Registre central des services
- **API Gateway** (port 8899) : Point d'entrée unique et routage intelligent
- **Client Service** : Gestion complète de la clientèle
- **Vehicule Service** : Administration du parc automobile
- **Reparation Service** : Suivi des interventions techniques

### **Frontend - Application React.js**
- Framework : React 18+ avec Hooks modernes
- Navigation : React Router v6
- Gestion d'état : Context API pour le thème
- Communication : Axios pour les requêtes HTTP
- Styling : CSS3 avec design responsive

## Stack Technologique

| Composant | Technologies |
|-----------|-------------|
| **Backend** | Java 17, Spring Boot 3, Spring Cloud, Spring Data JPA, Maven |
| **Frontend** | React 18, React Router 6, Axios, CSS Modules |
| **Infrastructure** | Docker, Docker Compose, Eureka, API Gateway |
| **Outils** | Postman, Git, Maven, npm |

## Fonctionnalités Clés

### **Backend Microservices**
- ✅ Découverte de services automatique via Eureka
- ✅ Gateway API centralisée pour un accès unifié
- ✅ Services déployables indépendamment
- ✅ Architecture résiliente et scalable
- ✅ Conteneurisation complète avec Docker

### **Frontend React**
- ✅ Interface utilisateur intuitive et moderne
- ✅ Navigation fluide entre les modules
- ✅ Système de thème (clair/sombre) persistant
- ✅ Opérations CRUD complètes pour toutes les entités
- ✅ Recherche et filtrage en temps réel
- ✅ Validation des données côté client

## Déploiement et Installation

### **Prérequis Système**
- Docker Engine 20.10+
- Docker Compose 2.0+
- Node.js 18+ et npm
- 4GB RAM minimum recommandé

### **Procédure d'Installation**

#### **Étape 1 : Initialisation des Services Backend**
```bash
# Démarrer l'infrastructure de base
docker-compose up -d eureka-server api-gateway

# Démarrer les services métier
docker-compose up -d client-service vehicule-service reparation-service

# Vérifier l'état des services
docker-compose ps
```

#### **Étape 2 : Déploiement du Frontend**
```bash
# Installation des dépendances
cd frontend
npm install

# Lancement de l'application en mode développement
npm start
```

#### **Étape 3 : Accès aux Applications**
| Composant | URL d'accès | Port | Description |
|-----------|-------------|------|-------------|
| **Application** | http://localhost:3000 | 3000 | Interface utilisateur principale |
| **API Gateway** | http://localhost:8899 | 8899 | Point d'accès aux APIs |
| **Eureka Console** | http://localhost:8761 | 8761 | Monitoring des services |

## Configuration

### **Configuration du Frontend**
```javascript
// Configuration de base dans src/services/api.js
const API_CONFIG = {
  baseURL: "http://localhost:8899",
  timeout: 10000,
  headers: {
    "Content-Type": "application/json",
    "Accept": "application/json"
  }
};
```

## Tests d'Intégration - Collection Postman

### **URL de Base pour les Tests**
```
http://localhost:8899
```

### ** Service Client - Endpoints**

#### **1. Création d'un Nouveau Client**
- **Méthode** : `POST`
- **Endpoint** : `/clients`
- **Corps de la Requête** :
```json
{
  "nom": "Ahmed Benali",
  "contact": "0666778899"
}
```

#### **2. Consultation de Tous les Clients**
- **Méthode** : `GET`
- **Endpoint** : `/clients`

#### **3. Consultation d'un Client Spécifique**
- **Méthode** : `GET`
- **Endpoint** : `/clients/{id}`

#### **4. Mise à Jour des Informations Client**
- **Méthode** : `PUT`
- **Endpoint** : `/clients/{id}`
- **Corps de la Requête** :
```json
{
  "nom": "Ahmed Modifié",
  "contact": "0612345678"
}
```

#### **5. Suppression d'un Client**
- **Méthode** : `DELETE`
- **Endpoint** : `/clients/{id}`

### ** Service Véhicule - Endpoints**

#### **6. Enregistrement d'un Nouveau Véhicule**
- **Méthode** : `POST`
- **Endpoint** : `/vehicules`
- **Corps de la Requête** :
```json
{
  "marque": "Toyota",
  "modele": "Corolla",
  "clientId": 1
}
```

#### **7. Liste Complète des Véhicules**
- **Méthode** : `GET`
- **Endpoint** : `/vehicules`

#### **8. Consultation d'un Véhicule par ID**
- **Méthode** : `GET`
- **Endpoint** : `/vehicules/{id}`

#### **9. Véhicules par Client**
- **Méthode** : `GET`
- **Endpoint** : `/vehicules/client/{clientId}`

#### **10. Suppression d'un Véhicule**
- **Méthode** : `DELETE`
- **Endpoint** : `/vehicules/{id}`

### ** Service Réparation - Endpoints**

#### **11. Création d'une Nouvelle Réparation**
- **Méthode** : `POST`
- **Endpoint** : `/reparations`
- **Corps de la Requête** :
```json
{
  "vehiculeId": 1,
  "description": "Changement de freins",
  "date": "2025-01-10"
}
```

#### **12. Liste des Réparations**
- **Méthode** : `GET`
- **Endpoint** : `/reparations`

#### **13. Consultation d'une Réparation**
- **Méthode** : `GET`
- **Endpoint** : `/reparations/{id}`

#### **14. Réparations par Véhicule**
- **Méthode** : `GET`
- **Endpoint** : `/reparations/vehicule/{vehiculeId}`

#### **15. Suppression d'une Réparation**
- **Méthode** : `DELETE`
- **Endpoint** : `/reparations/{id}`

## Guide d'Utilisation de l'Interface

### **Tableau de Bord Principal**
- Vue consolidée des principales métriques
- Accès rapide aux modules fonctionnels via cartes interactives
- Design moderne avec indicateurs visuels

### **Module Gestion Clients**
1. **Ajout Client** : Formulaire simplifié avec validation
2. **Recherche** : Filtrage dynamique par nom et contact
3. **Édition** : Modification directe des informations
4. **Suppression** : Mécanisme de confirmation à double validation

### **Module Gestion Véhicules**
1. **Enregistrement** : Association automatique au client
2. **Spécifications** : Saisie des caractéristiques techniques
3. **Recherche Avancée** : Filtres combinés marque/modèle
4. **Visualisation** : Affichage du propriétaire associé

### **Module Gestion Réparations**
1. **Saisie Intervention** : Description détaillée avec date
2. **Liaison Véhicule** : Sélection dans la liste existante
3. **Filtrage** : Recherche par période et description
4. **Historique** : Consultation chronologique des interventions

## Workflow de Développement

### **Environnement de Développement Local**
```bash
# Backend - Mode développement (sans Docker)
mvn clean install
mvn spring-boot:run -pl client-service

# Frontend - Mode développement
npm run dev
```

### **Construction des Images Docker**
```bash
# Construction complète
docker-compose build --no-cache

# Construction sélective
docker-compose build client-service
```

### **Tests et Validation**
- Exécution de la collection Postman fournie
- Tests d'intégration manuels sur l'interface
- Validation des flux métier complets

## Structure de l'Application

```
vehicle-repair-system/
├── backend/                    # Écosystème microservices
│   ├── eureka-server/         # Service discovery
│   ├── api-gateway/           # Routeur API central
│   ├── client-service/        # Module clients
│   ├── vehicule-service/      # Module véhicules
│   ├── reparation-service/    # Module réparations
│   └── docker-compose.yml     # Orchestration conteneurs
├── frontend/                  # Application React
│   ├── src/pages/            # Pages principales
│   ├── src/services/         # Clients API
│   ├── src/context/          # Gestion état global
│   └── package.json          # Dépendances frontend
└── README.md                  # Documentation
```

## Évolutions et Roadmap

### **Améliorations Immédiates (Q1)**
- Implémentation d'authentification JWT
- Validation avancée des formulaires
- Pagination des listes longues
- Export des données en formats standard

### **Développements Moyen Terme (Q2-Q3)**
- Système de notifications en temps réel
- Tableaux de bord analytiques avec graphiques
- Génération automatisée de documents PDF
- Synchronisation avec applications mobiles

### **Évolutions Long Terme (Q4+)**
- Extension de l'architecture microservices
- Intégration de solutions de paiement
- Exposition d'API publique pour partenaires
- Fonctionnalités de prédiction maintenance

## Bonnes Pratiques Implémentées

### **Backend**
- Architecture modulaire avec séparation des responsabilités
- Centralisation du routage via API Gateway
- Découverte dynamique des services
- Conteneurisation pour portabilité maximale

### **Frontend**
- Composants React réutilisables et modulaires
- Gestion d'état centralisée avec Context API
- Code splitting pour optimisation des performances
- Interface responsive adaptée à tous les devices


##  Information Projet

**Nom du Projet** : Vehicle Repair Management System  
**Type** : Solution de gestion d'atelier automobile  
**Architecture** : Microservices Full Stack  
**Période de Développement** : Année Universitaire 2025-2026  

**Équipe de Développement** :
- FEKNI Safaa - Architecte Backend & Frontend
- BACHRI Fatima Ezzahra - Développeuse Full Stack

**Encadrement Pédagogique** :
- Mr. HABIB Ayad - Encadrant Technique

**Technologies Maîtrisées** :
- Java, Spring Boot, Spring Cloud
- React.js, Docker, Microservices
- Architecture distribuée, API Gateway


---

**Démarrage Rapide** : Exécutez `docker-compose up --build` puis `npm start` dans le dossier frontend pour lancer l'application complète.
