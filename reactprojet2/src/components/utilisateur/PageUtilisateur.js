import React, {useState} from 'react';
import Utilisateurs from "./Utilisateurs";
import InscriptionUtilisateur from "./inscription/InscriptionUtilisateur";
import ConnexionUtilisateur from "./connexion/ConnexionUtilisateur";

const PageUtilisateur = () => {
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

    const connexion = async (utilisateur) => {
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
    }

    return (
        <div className='container'>
            {<InscriptionUtilisateur onAdd={inscription} />}
            {<ConnexionUtilisateur onAdd={connexion} />}
            {utilisateurs.length > 0 ?
                console.log(<Utilisateurs utilisateurs={utilisateurs}/>)
                : console.log('nothing yet')}
        </div>
    );
};

export default PageUtilisateur;
