import { FaTimes } from 'react-icons/fa'
import './../../App.css'

const Recette = ({recette, onDelete, onUpdate}) => {
    return (
        <div className="recette"
             onDoubleClick={() => onUpdate(recette)}>
            <table>
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
                    <tr>
                        <td>{recette.titre}</td>
                        <td>{recette.portion}</td>
                        <td>{recette.calories}</td>
                        <td>
                            <ul>
                                {recette.ingredientDtos.map((i) => <li>{i.nom}</li>)}
                            </ul>
                        </td>
                        <td>Effacer <FaTimes
                            style={{color: 'red', cursor: 'pointer'}}
                            onClick={() => onDelete(recette.id)}/></td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default Recette
