import Recette from "./Recette";
import Table from 'react-bootstrap/Table'

const Recettes = ({recettes, onDelete, onUpdate, showUpdate}) => {
    return (
        <>
            <div>
                <Table>
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Portions</th>
                        <th>Calories</th>
                        <th>Ingrédients</th>
                        <th>Supprimer la recette</th>
                    </tr>
                    </thead>
                    <tbody>
                        {recettes.map((recette) => (
                            <Recette key={recette.id}
                                     recette={recette}
                                     onDelete={onDelete}
                                     onUpdate={onUpdate}
                                     showUpdate={showUpdate}/>
                        ))}
                    </tbody>
                </Table>
            </div>
        </>
    )
}

export default Recettes
