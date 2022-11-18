import './../../../App.css'

const Ingredient = ({ingredient}) => {
    return (
        <div className="ingredient">
            <li>{ingredient.nom}</li>
        </div>
    )
}

export default Ingredient
