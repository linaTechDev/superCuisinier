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
        <form className='add-form' onSubmit={onSubmit}>
            <Header/>
            <div className='form-control'>
                <label>Nom d'utilisateur</label>
                <input type='text' placeholder='Nom utilisateur'
                       value={nomUtilisateur}
                       onChange={(e) => setNomUtilisateur(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Mot de passe</label>
                <input type='password' placeholder='Mot de passe'
                       value={motPasse}
                       onChange={(e) => setMotPasse(e.target.value)}/>
            </div>
            <input type='submit' value='Connexion' className='btn btn-block bg-black text-light'/>
        </form>
    )
}

export default ConnexionUtilisateur
