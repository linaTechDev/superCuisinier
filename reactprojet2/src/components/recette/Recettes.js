import Recette from "./Recette";

const Recettes = ({recettes, onDelete, onUpdate, showUpdate}) => {
    return (
        <>
            {recettes.map((recette) => (
                <Recette key={recette.id}
                       recette={recette}
                       onDelete={onDelete}
                       onUpdate={onUpdate}
                       showUpdate={showUpdate}/>
            ))}
        </>
    )
}

export default Recettes
