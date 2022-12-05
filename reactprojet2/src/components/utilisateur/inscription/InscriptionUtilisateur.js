import {useState} from "react";
import "./InscriptionPage.css"

const InscriptionUtilisateur = ({onAdd}) => {
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
        <div className='card-body'>
            <form autoComplete="off" className='add-form' onSubmit={onSubmit}>
                <div className='form-group'>
                    <label>Nom d'utilisateur</label>
                    <input className='form-control saisie saisie-user' type='text' placeholder='Nom utilisateur'
                           value={nomUtilisateur}
                           onChange={(e) => setNomUtilisateur(e.target.value)}/>
                </div>
                <div className='form-group'>
                    <label>Prenom</label>
                    <input className='form-control saisie saisie-user' type='text' placeholder='Prenom'
                           value={prenom}
                           onChange={(e) => setPrenom(e.target.value)}/>
                </div>
                <div className='form-group'>
                    <label>Nom de famille</label>
                    <input className='form-control saisie saisie-user' type='text' placeholder='Nom de famille'
                           value={nomFamille}
                           onChange={(e) => setNomFamille(e.target.value)}/>
                </div>
                <div className='form-group'>
                    <label>Mot de passe</label>
                    <input className='form-control saisie saisie-psw' type='password' placeholder='Mot de passe'
                           value={motPasse}
                           onChange={(e) => setMotPasse(e.target.value)}/>
                </div>
                <input type='submit' value='Inscription' className='btn btn-block bg-black text-light'/>
            </form>
        </div>
    )
}

export default InscriptionUtilisateur
