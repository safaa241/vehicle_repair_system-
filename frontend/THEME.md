# 🌙 Mode Sombre & Mode Clair

## Overview
RepairFlow inclut un système de thème complet avec mode sombre (dark mode) et mode clair (light mode).

## Caractéristiques

### 🎨 Fonctionnalités
- ✅ Basculement facile entre les deux modes via un bouton dans la navbar
- ✅ Sauvegarde de la préférence dans localStorage
- ✅ Support de la préférence système (prefers-color-scheme)
- ✅ Transitions fluides entre les thèmes
- ✅ Compatible avec tous les navigateurs modernes

### 📱 Mode Clair (Light Mode)
- **Couleurs principales**: Gradients vibrantes (#667eea → #764ba2 → #f093fb)
- **Arrière-plan**: Blanc cassé avec dégradés subtils
- **Texte**: Couleurs sombres pour meilleure lisibilité
- **Cartes**: Blanc avec ombres douces

### 🌙 Mode Sombre (Dark Mode)
- **Couleurs principales**: Gradients bleutés foncés (#1a1a2e → #16213e → #0f3460)
- **Arrière-plan**: Gris très foncé/noir
- **Texte**: Gris clair (#e0e0e0) pour confort oculaire
- **Cartes**: Fond semi-transparent foncé avec ombres plus fortes

## Architecture

### Fichiers principaux
1. **src/context/ThemeContext.jsx** - Contexte React pour la gestion du thème
2. **src/hooks/useTheme.js** - Hook personnalisé pour accéder au thème

### Utilisation dans les composants

```jsx
import { useTheme } from './hooks/useTheme';

function MonComposant() {
  const { isDark, toggleTheme } = useTheme();
  
  return (
    <button onClick={toggleTheme}>
      {isDark ? '☀️ Clair' : '🌙 Sombre'}
    </button>
  );
}
```

## CSS avec Thèmes

### Sélecteur d'attribut
```css
/* Style clair (par défaut) */
.element {
  background: white;
  color: #2c3e50;
}

/* Style sombre */
[data-theme="dark"] .element {
  background: rgba(30, 30, 46, 0.7);
  color: #e0e0e0;
}
```

## Stockage

Le thème est sauvegardé dans `localStorage` avec la clé `theme`:
- `"light"` - Mode clair
- `"dark"` - Mode sombre

À la prochaine visite, le thème préféré sera automatiquement appliqué.

## Préférence Système

Si aucune préférence n'est sauvegardée, l'application détecte automatiquement:
```javascript
window.matchMedia("(prefers-color-scheme: dark)").matches
```

## Bouton Toggle dans la Navbar

Le bouton en haut à droite permet de basculer entre les modes:
- **Mode Clair**: Affiche 🌙 (Lune)
- **Mode Sombre**: Affiche ☀️ (Soleil)

### Animation du bouton
- Transition fluide avec cubic-bezier
- Rotation au survol (20°)
- Pulsation au clic

## Pages Supportées

✅ Home (Accueil)
✅ Dashboard
✅ Vehicules
✅ Clients
✅ Reparations
✅ Navigation (Navbar)
✅ Index global (body, inputs, etc.)

## Transitions Douces

Toutes les transitions de couleur utilisent:
```css
transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;
```

Cela assure des changements fluides lorsque l'utilisateur bascule entre les thèmes.

## Contraste d'Accessibilité

Les couleurs en mode sombre sont choisies pour:
- Ratio de contraste WCAG AA minimum (4.5:1 pour le texte)
- Réduction de la fatigue oculaire
- Meilleure lisibilité en environnement faiblement éclairé

## Fichiers CSS Modifiés

- `src/index.css` - Variables globales et styles par défaut
- `src/App.css` - Navbar et navigation
- `src/pages/Home.css` - Page d'accueil
- `src/pages/Dashboard.css` - Dashboard
- `src/pages/Vehicules.css` - Page véhicules
- `src/pages/Clients.css` - Page clients
- `src/pages/Reparations.css` - Page réparations

## Customisation

Pour ajouter le thème sombre à un nouveau composant:

1. Ajouter les styles par défaut (mode clair)
2. Ajouter les styles `[data-theme="dark"]` correspondants
3. Assurer les transitions fluides

Exemple:
```css
.monElement {
  background: white;
  color: #333;
  transition: all 0.3s ease;
}

[data-theme="dark"] .monElement {
  background: #1a1a2e;
  color: #e0e0e0;
}
```

## Performance

- Pas de rechargement de page
- Changement instantané via CSS
- LocalStorage pour persistance
- Aucun impact sur les performances
