import { FaTimes, FaRegArrowAltCircleUp } from 'react-icons/fa'
import './../../../App.css'

const GardeManger = ({gardeManger, recettes, onDelete, onUpdate, onRecettes}) => {
    return (
        <div className="gardeManger"
             onDoubleClick={() => onUpdate(gardeManger)}>
            <p>{gardeManger.nom}</p>
            <ul>
                {gardeManger.ingredientDtos.map((i) => <li>{i.nom}</li>)}
            </ul>
            <hr/>
            <ul>
                {recettes.map((r) => <li>{r.titre}</li>)}
            </ul>
            <p>Effacer <FaTimes
                style={{color: 'red', cursor: 'pointer'}}
                onClick={() => onDelete(gardeManger.id)}/>
            </p>
            <p>Recettes <FaRegArrowAltCircleUp
                style={{color: 'blue', cursor: 'pointer'}}
                onClick={() => onRecettes(gardeManger.id)}/>
            </p>
        </div>
    )
}

export default GardeManger
