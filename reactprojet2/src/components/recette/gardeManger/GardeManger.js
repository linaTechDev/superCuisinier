import { FaTimes } from 'react-icons/fa'
import './../../../App.css'

const GardeManger = ({gardeManger, onDelete, onUpdate}) => {
    return (
        <div className="gardeManger"
             onDoubleClick={() => onUpdate(gardeManger)}>
            <p>{gardeManger.nom}</p>
            <ul>
                {gardeManger.ingredientDtos.map((i) => <li>{i.nom}</li>)}
            </ul>
            <p>Effacer <FaTimes
                style={{color: 'red', cursor: 'pointer'}}
                onClick={() => onDelete(gardeManger.id)}/>
            </p>
        </div>
    )
}

export default GardeManger
