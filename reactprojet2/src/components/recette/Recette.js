import { FaTimes } from 'react-icons/fa'

const Recette = ({recette, onDelete, onUpdate}) => {
    return (
        <tr className="recette"
            onDoubleClick={() => onUpdate(recette)}>
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
    )
}

export default Recette
