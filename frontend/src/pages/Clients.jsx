import { useEffect, useState } from "react";
import { getClients, createClient, updateClient, deleteClient } from "../services/clientService";
import "./Clients.css";

export default function Clients() {
  const [clients, setClients] = useState([]);
  const [nom, setNom] = useState("");
  const [contact, setContact] = useState("");
  const [editingId, setEditingId] = useState(null);
  const [searchNom, setSearchNom] = useState("");
  const [searchContact, setSearchContact] = useState("");

  const loadClients = () => {
    getClients().then(res => setClients(res.data));
  };

  useEffect(() => {
    loadClients();
  }, []);

  const filteredClients = clients.filter(c => 
    c.nom.toLowerCase().includes(searchNom.toLowerCase()) &&
    c.contact.toLowerCase().includes(searchContact.toLowerCase())
  );

  const submit = () => {
    if (editingId) {
      updateClient(editingId, { nom, contact }).then(() => {
        setNom("");
        setContact("");
        setEditingId(null);
        loadClients();
      });
    } else {
      createClient({ nom, contact }).then(() => {
        setNom("");
        setContact("");
        loadClients();
      });
    }
  };

  const handleEdit = (client) => {
    setNom(client.nom);
    setContact(client.contact);
    setEditingId(client.id);
  };

  const handleDelete = (id) => {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce client ?")) {
      deleteClient(id).then(() => loadClients());
    }
  };

  return (
    <div className="clients-container">
      <h2>👥 Clients</h2>

      <div className="filter-section">
        <h3>🔍 Filtrer & Rechercher</h3>
        <div className="filter-group">
          <input 
            placeholder="🔎 Chercher par nom..." 
            value={searchNom} 
            onChange={e => setSearchNom(e.target.value)}
            className="filter-input"
          />
          <input 
            placeholder="🔎 Chercher par contact..." 
            value={searchContact} 
            onChange={e => setSearchContact(e.target.value)}
            className="filter-input"
          />
          <button className="btn-reset" onClick={() => { setSearchNom(""); setSearchContact(""); }}>✕ Réinitialiser</button>
        </div>
        <p className="filter-count">Résultats: <span className="count-highlight">{filteredClients.length}</span> / {clients.length}</p>
      </div>

      <div className="form-section">
        <h3>➕ Ajouter / Modifier</h3>
        <div className="form-group">
          <input placeholder="Nom" value={nom} onChange={e => setNom(e.target.value)} />
          <input placeholder="Contact" value={contact} onChange={e => setContact(e.target.value)} />
          <button className="btn-add" onClick={submit}>{editingId ? "✏️ Modifier" : "➕ Ajouter"}</button>
          {editingId && <button className="btn-cancel" onClick={() => { setEditingId(null); setNom(""); setContact(""); }}>✕ Annuler</button>}
        </div>
      </div>

      <ul className="clients-list">
        {filteredClients.length > 0 ? (
          filteredClients.map(c => (
            <li key={c.id}>
              <span>{c.nom} - {c.contact}</span>
              <div>
                <button onClick={() => handleEdit(c)}>✎ Modifier</button>
                <button onClick={() => handleDelete(c.id)}>🗑 Supprimer</button>
              </div>
            </li>
          ))
        ) : (
          <li className="no-results">Aucun client trouvé</li>
        )}
      </ul>
    </div>
  );
}
