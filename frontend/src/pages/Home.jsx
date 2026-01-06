import "./Home.css";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div className="home-container">
      <div className="home-content">
        <h1 className="title">🏢 Atelier Gestion</h1>
        <p className="subtitle">Système de gestion des véhicules et réparations</p>

        <div className="cards-grid">
          <Link to="/vehicules" className="card vehicles-card">
            <div className="card-icon">🚗</div>
            <h2>Véhicules</h2>
            <p>Gérez votre parc de véhicules</p>
            <div className="card-action">Accéder →</div>
          </Link>

          <Link to="/clients" className="card clients-card">
            <div className="card-icon">👥</div>
            <h2>Clients</h2>
            <p>Gérez les informations des clients</p>
            <div className="card-action">Accéder →</div>
          </Link>

          <Link to="/reparations" className="card reparations-card">
            <div className="card-icon">🔧</div>
            <h2>Réparations</h2>
            <p>Suivez les réparations effectuées</p>
            <div className="card-action">Accéder →</div>
          </Link>
        </div>

        <div className="stats-section">
          <div className="stat-box">
            <span className="stat-number">100+</span>
            <span className="stat-label">Véhicules</span>
          </div>
          <div className="stat-box">
            <span className="stat-number">500+</span>
            <span className="stat-label">Clients</span>
          </div>
          <div className="stat-box">
            <span className="stat-number">1000+</span>
            <span className="stat-label">Réparations</span>
          </div>
        </div>

        <div className="footer-text">
          <p>Bienvenue dans votre système de gestion d'atelier automobile</p>
          
        </div>
      </div>
    </div>
  );
}
