import React, {useState} from 'react';
import InscriptionUtilisateur from "./InscriptionUtilisateur";
import {Link, Navigate} from "react-router-dom";
import "./InscriptionPage.css"
import Header from "./Header";

const InscriptionPage = () => {
    const [utilisateurs, setUtilisateurs] = useState([])
    const inscription = async (utilisateur) => {
        const res = await fetch('http://localhost:8080/utilisateur/creation',
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify(utilisateur)
            })
        const data = await res.json()
        setUtilisateurs([...utilisateurs, data])
    }

    return (
        <div className='fondInscription'>
            <Header/>
            {<InscriptionUtilisateur onAdd={inscription} />}
            <Link to='/connexion' className="goConnexion">Retour</Link>
            {utilisateurs.length > 0 ?
                <Navigate to="/connexion"/>
                : console.log('nothing yet')}
        </div>
    );
};

export default InscriptionPage;
