import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { useContext } from "react";
import { ThemeContext } from "./context/ThemeContext";
import Home from "./pages/Home";
import Clients from "./pages/Clients";
import Vehicules from "./pages/Vehicules";
import Reparations from "./pages/Reparations";
import "./App.css";

export default function App() {
  const { isDark, toggleTheme } = useContext(ThemeContext);

  return (
    <BrowserRouter>
      <nav className="navbar">
        <div className="nav-container">
          <Link to="/" className="nav-logo">
            🏢 RepairFlow
          </Link>
          <div className="nav-menu">
            <Link to="/" className="nav-link">
              Accueil
            </Link>
            <Link to="/vehicules" className="nav-link">
              🚗 Véhicules
            </Link>
            <Link to="/clients" className="nav-link">
              👥 Clients
            </Link>
            <Link to="/reparations" className="nav-link">
              🔧 Réparations
            </Link>
            <button 
              className="theme-toggle"
              onClick={toggleTheme}
              title={isDark ? "Mode clair" : "Mode sombre"}
            >
              {isDark ? "☀️" : "🌙"}
            </button>
          </div>
        </div>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/vehicules" element={<Vehicules />} />
        <Route path="/clients" element={<Clients />} />
        <Route path="/reparations" element={<Reparations />} />
      </Routes>
    </BrowserRouter>
  );
}
