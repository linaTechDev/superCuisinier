import {useState} from "react";
import Header from "./Header";
import './../../style.css'

const SaveUtilisateur = ({onAdd}) => {
    const [nomUtilisateur, setNomUtilisateur] = useState('');
    const [prenom, setPrenom] = useState('');
    const [nomFamille, setNomFamille] = useState('');
    const [motPasse,setMotPasse] = useState('');

    const onSubmit = (e) => {
        e.preventDefault()

        if (
            !nomUtilisateur &&
            !prenom &&
            !nomFamille &&
            !motPasse
        ) {
            alert('Veuillez remplir les champs d\'inscription')
        }

        if (
            !nomUtilisateur
        ) {
            alert('Veuillez ajouter le nom d\'utilisateur')
            return
        }

        if (
            !prenom
        ) {
            alert('Veuillez ajouter le prénom')
            return
        }

        if (
            !nomFamille
        ) {
            alert('Veuillez ajouter le nom de famille')
            return
        }

        if (
            !motPasse
        ) {
            alert('Veuillez ajouter le mot de passe')
            return
        }

        onAdd({
            nomUtilisateur,
            prenom,
            nomFamille,
            motPasse
        })
        setNomUtilisateur('')
        setPrenom('')
        setNomFamille('')
        setMotPasse('')
    }

    return (
        <form className='add-form' onSubmit={onSubmit}>
            <Header/>
            <div className='form-control'>
                <label>Nom d'utilisateur</label>
                <input type='text' placeholder='Nom utilisateur'
                       value={nomUtilisateur}
                       onChange={(e) => setNomUtilisateur(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Prenom</label>
                <input type='text' placeholder='Prenom'
                       value={prenom}
                       onChange={(e) => setPrenom(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Nom de famille</label>
                <input type='text' placeholder='Nom de famille'
                       value={nomFamille}
                       onChange={(e) => setNomFamille(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Mot de passe</label>
                <input type='password' placeholder='Mot de passe'
                       value={motPasse}
                       onChange={(e) => setMotPasse(e.target.value)}/>
            </div>
            <input type='submit' value='Save Utilisateur' className='btn btn-block bg-black text-light'/>
        </form>
    )
}

export default SaveUtilisateur
