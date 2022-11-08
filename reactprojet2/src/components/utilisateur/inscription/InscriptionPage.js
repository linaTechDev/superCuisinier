import React, {useState} from 'react';
import InscriptionUtilisateur from "./InscriptionUtilisateur";
import {Navigate} from "react-router-dom";

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
        <div className='container'>
            {<InscriptionUtilisateur onAdd={inscription} />}
            {utilisateurs.length > 0 ?
                <Navigate to="/connexion"/>
                : console.log('nothing yet')}
        </div>
    );
};

export default InscriptionPage;
