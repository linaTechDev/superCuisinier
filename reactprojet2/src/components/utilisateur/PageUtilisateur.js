import React, {useState} from 'react';
import Utilisateurs from "./Utilisateurs";
import SaveUtilisateur from "./SaveUtilisateur";

const PageUtilisateur = () => {
    const [utilisateurs, setUtilisateurs] = useState([])

    const addUtilisateur = async (utilisateur) => {
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
            {<SaveUtilisateur onAdd={addUtilisateur} />}
            {utilisateurs.length > 0 ?
                console.log(<Utilisateurs utilisateurs={utilisateurs}/>)
                : console.log('No Utilisateurs')}
        </div>
    );
};

export default PageUtilisateur;
