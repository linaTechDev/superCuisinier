const Utilisateur = ({utilisateur}) => {
    return (
        <div className="utilisateur">
            <h3>{utilisateur.nomUtilisateur}</h3>
            <h3>{utilisateur.prenom}</h3>
            <h3>{utilisateur.nomFamille}</h3>
        </div>
    )
}

export default Utilisateur
