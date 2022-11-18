import './App.css';
import {Navigate, Route, Routes} from "react-router-dom";
import PageNotFound from "./components/PageNotFound";
import HomePage from "./components/HomePage";
import ConnexionPage from "./components/utilisateur/connexion/ConnexionPage";
import InscriptionPage from "./components/utilisateur/inscription/InscriptionPage";
import React from "react";
import {isConnected} from "./components/utilisateur/connexion/ConnexionPage"
import PageRecette from "./components/recette/PageRecette";
import AddIngredients from "./components/recette/ingredient/AddIngredients";
import PageIngredient from "./components/recette/ingredient/PageIngredient";

function App() {
    return (
        <div>
          <h1>Super cuisinier</h1>
          <Routes>
              <Route path="/"
                     element={
                         !isConnected() ?
                             <Navigate to="/connexion"/> :
                             <Navigate to="/accueil"/>
                     }
              />
              <Route path="*" element={<PageNotFound/>} />
              <Route path="/connexion" element={<ConnexionPage/>}/>
              <Route path="/creation" element={<InscriptionPage/>} />
              <Route path="/accueil" element={<HomePage/>}/>
              <Route path="/recette" element={<PageRecette/>}/>
              <Route path="/ingredientAdd" element={<AddIngredients/>}/>
              <Route path="/ingredient" element={<PageIngredient/>}/>
          </Routes>
        </div>
    );
}

export default App;
