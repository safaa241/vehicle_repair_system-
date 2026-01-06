import { useEffect, useState } from "react";
import { getReparations, createReparation, updateReparation, deleteReparation } from "../services/reparationService";
import "./Reparations.css";

export default function Reparations() {
  const [reparations, setReparations] = useState([]);
  const [description, setDescription] = useState("");
  const [date, setDate] = useState("");
  const [editingId, setEditingId] = useState(null);
  const [searchDescription, setSearchDescription] = useState("");
  const [searchDate, setSearchDate] = useState("");

  const load = () => {
    getReparations().then(res => setReparations(res.data));
  };

  useEffect(() => {
    load();
  }, []);

  const filteredReparations = reparations.filter(r => 
    r.description.toLowerCase().includes(searchDescription.toLowerCase()) &&
    (searchDate === "" || r.date === searchDate)
  );

  const submit = () => {
    if (editingId) {
      updateReparation(editingId, { description, date }).then(() => {
        setDescription("");
        setDate("");
        setEditingId(null);
        load();
      });
    } else {
      createReparation({ description, date }).then(() => {
        setDescription("");
        setDate("");
        load();
      });
    }
  };

  const handleEdit = (reparation) => {
    setDescription(reparation.description);
    setDate(reparation.date);
    setEditingId(reparation.id);
  };

  const handleDelete = (id) => {
    if (confirm("Êtes-vous sûr de vouloir supprimer cette réparation ?")) {
      deleteReparation(id).then(() => load());
    }
  };

  return (
    <div className="reparations-container">
      <h2>🔧 Réparations</h2>

      <div className="filter-section">
        <h3>🔍 Filtrer & Rechercher</h3>
        <div className="filter-group">
          <input 
            placeholder="🔎 Chercher par description..." 
            value={searchDescription} 
            onChange={e => setSearchDescription(e.target.value)}
            className="filter-input"
          />
          <input 
            type="date"
            placeholder="🔎 Chercher par date..." 
            value={searchDate} 
            onChange={e => setSearchDate(e.target.value)}
            className="filter-input"
          />
          <button className="btn-reset" onClick={() => { setSearchDescription(""); setSearchDate(""); }}>✕ Réinitialiser</button>
        </div>
        <p className="filter-count">Résultats: <span className="count-highlight">{filteredReparations.length}</span> / {reparations.length}</p>
      </div>

      <div className="form-section">
        <h3>➕ Ajouter / Modifier</h3>
        <div className="form-group">
          <input placeholder="Description" value={description} onChange={e => setDescription(e.target.value)} />
          <input type="date" value={date} onChange={e => setDate(e.target.value)} />
          <button className="btn-add" onClick={submit}>{editingId ? "✏️ Modifier" : "➕ Ajouter"}</button>
          {editingId && <button className="btn-cancel" onClick={() => { setEditingId(null); setDescription(""); setDate(""); }}>✕ Annuler</button>}
        </div>
      </div>

      <ul className="reparations-list">
        {filteredReparations.length > 0 ? (
          filteredReparations.map(r => (
            <li key={r.id}>
              <span>{r.description} - {r.date}</span>
              <div>
                <button onClick={() => handleEdit(r)}>✎ Modifier</button>
                <button onClick={() => handleDelete(r.id)}>🗑 Supprimer</button>
              </div>
            </li>
          ))
        ) : (
          <li className="no-results">Aucune réparation trouvée</li>
        )}
      </ul>
    </div>
  );
}
