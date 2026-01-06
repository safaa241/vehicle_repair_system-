import { useEffect, useState } from "react";
import { getVehicules, createVehicule, updateVehicule, deleteVehicule } from "../services/vehiculeService";
import { getClients } from "../services/clientService";
import "./Vehicules.css";

export default function Vehicules() {
  const [vehicules, setVehicules] = useState([]);
  const [clients, setClients] = useState([]);
  const [marque, setMarque] = useState("");
  const [modele, setModele] = useState("");
  const [clientId, setClientId] = useState("");
  const [editingId, setEditingId] = useState(null);
  const [searchMarque, setSearchMarque] = useState("");
  const [searchModele, setSearchModele] = useState("");

  const load = () => {
    getVehicules().then(res => setVehicules(res.data));
    getClients().then(res => setClients(res.data));
  };

  useEffect(() => {
    load();
  }, []);

  const filteredVehicules = vehicules.filter(v => 
    v.marque.toLowerCase().includes(searchMarque.toLowerCase()) &&
    v.modele.toLowerCase().includes(searchModele.toLowerCase())
  );

  const submit = () => {
    if (!marque || !modele || !clientId) {
      alert("Veuillez remplir tous les champs");
      return;
    }
    
    if (editingId) {
      updateVehicule(editingId, { marque, modele, clientId: parseInt(clientId) }).then(() => {
        setMarque("");
        setModele("");
        setClientId("");
        setEditingId(null);
        load();
      });
    } else {
      createVehicule({ marque, modele, clientId: parseInt(clientId) }).then(() => {
        setMarque("");
        setModele("");
        setClientId("");
        load();
      });
    }
  };

  const handleEdit = (vehicule) => {
    setMarque(vehicule.marque);
    setModele(vehicule.modele);
    setClientId(vehicule.clientId || "");
    setEditingId(vehicule.id);
  };

  const handleDelete = (id) => {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce véhicule ?")) {
      deleteVehicule(id).then(() => load());
    }
  };

  return (
    <div className="vehicules-container">
      <h2>🚗 Véhicules</h2>

      <div className="filter-section">
        <h3>🔍 Filtrer & Rechercher</h3>
        <div className="filter-group">
          <input 
            placeholder="🔎 Chercher par marque..." 
            value={searchMarque} 
            onChange={e => setSearchMarque(e.target.value)}
            className="filter-input"
          />
          <input 
            placeholder="🔎 Chercher par modèle..." 
            value={searchModele} 
            onChange={e => setSearchModele(e.target.value)}
            className="filter-input"
          />
          <button className="btn-reset" onClick={() => { setSearchMarque(""); setSearchModele(""); }}>✕ Réinitialiser</button>
        </div>
        <p className="filter-count">Résultats: <span className="count-highlight">{filteredVehicules.length}</span> / {vehicules.length}</p>
      </div>

      <div className="form-section">
        <h3>➕ Ajouter / Modifier</h3>
        <div className="form-group">
          <input placeholder="Marque" value={marque} onChange={e => setMarque(e.target.value)} />
          <input placeholder="Modèle" value={modele} onChange={e => setModele(e.target.value)} />
          <select 
            value={clientId} 
            onChange={e => setClientId(e.target.value)}
            className="form-input"
          >
            <option value="">👥 Sélectionner un client...</option>
            {clients.map(c => (
              <option key={c.id} value={c.id}>{c.nom} ({c.contact})</option>
            ))}
          </select>
          <button className="btn-add" onClick={submit}>{editingId ? "✏️ Modifier" : "➕ Ajouter"}</button>
          {editingId && <button className="btn-cancel" onClick={() => { setEditingId(null); setMarque(""); setModele(""); setClientId(""); }}>✕ Annuler</button>}
        </div>
      </div>

      <ul className="vehicules-list">
        {filteredVehicules.length > 0 ? (
          filteredVehicules.map(v => (
            <li key={v.id}>
              <span>{v.marque} - {v.modele} {v.clientId && `(Client: ${clients.find(c => c.id === v.clientId)?.nom || 'N/A'})`}</span>
              <div>
                <button onClick={() => handleEdit(v)}>✎ Modifier</button>
                <button onClick={() => handleDelete(v.id)}>🗑 Supprimer</button>
              </div>
            </li>
          ))
        ) : (
          <li className="no-results">Aucun véhicule trouvé</li>
        )}
      </ul>
    </div>
  );
}
