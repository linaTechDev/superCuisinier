import React, {useState} from 'react';
import ConnexionUtilisateur from "./ConnexionUtilisateur";
import {Link, Navigate} from "react-router-dom";
import {CurrentUser} from "../Utilisateur";
import {isExpired} from "react-jwt";
const ConnexionPage = () => {
    const [utilisateurs, setUtilisateurs] = useState([]);

    async function connexion(utilisateur) {
        const res = await fetch('http://localhost:8080/utilisateur/connexion',
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify(utilisateur)
            })
        const data = await res.json()
        setUtilisateurs([...utilisateurs, data])
        const currentUser = new CurrentUser(data)
        localStorage.setItem('currentUser', JSON.stringify(currentUser))
        let jsonCurrentUser = localStorage.getItem('currentUser');
        console.log('isConnected',isConnected(jsonCurrentUser))
        console.log('nomPrenom',getConnectedUtilisateur(jsonCurrentUser))
        console.log('token',tokenUtilisateur(jsonCurrentUser))

    }

    return (
        <div className='container'>
            {<ConnexionUtilisateur onAdd={connexion} />}
            <Link to='/creation'>Pas de compte, inscrit toi</Link>
            {utilisateurs.length > 0 ?
                <Navigate to="/accueil"/>
                : console.log('nothing yet')}
        </div>
    );
};

export function isConnected(jsonCurrentUser) {
    console.log(jsonCurrentUser)
    if (jsonCurrentUser != null) {
        let currentUser = JSON.parse(jsonCurrentUser);

        if (isExpired(currentUser.props.token)) {
            localStorage.removeItem('currentUser');
        } else {
            return true;
        }
    }
    return false;
}

function getConnectedUtilisateur(jsonCurrentUser) {
    if (jsonCurrentUser != null) {
        const currentUser = JSON.parse(jsonCurrentUser);
        return currentUser.props.nomUtilisateur;
    }
    else {
        return "";
    }
}

function tokenUtilisateur(jsonCurrentUser) {
    if (jsonCurrentUser != null) {
        const currentUser = JSON.parse(jsonCurrentUser);
        if (isExpired(currentUser.props.token)) {
            localStorage.removeItem('currentUser');
            return "";
        }
        else {
            return currentUser.props.token;
        }
    }
    return "";
}

export default ConnexionPage;
