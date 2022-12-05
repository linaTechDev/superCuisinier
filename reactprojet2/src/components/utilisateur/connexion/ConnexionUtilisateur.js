import {useState} from "react";
import Header from "./Header";

const ConnexionUtilisateur = ({onAdd}) => {
    const [nomUtilisateur, setNomUtilisateur] = useState('');
    const [motPasse,setMotPasse] = useState('');

    const onSubmit = (e) => {
        e.preventDefault()

        if (
            !nomUtilisateur &&
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
            !motPasse
        ) {
            alert('Veuillez ajouter le mot de passe')
            return
        }

        onAdd({
            nomUtilisateur,
            motPasse
        })
        setNomUtilisateur('')
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
                    <label>Mot de passe</label>
                    <input className='form-control saisie saisie-psw' type='password' placeholder='Mot de passe'
                           value={motPasse}
                           onChange={(e) => setMotPasse(e.target.value)}/>
                </div>
                <div className='form-group'>
                    <input type='submit' value='Connexion' className='btn btn-primary'/>
                </div>
            </form>
        </div>
    )
}

export default ConnexionUtilisateur
