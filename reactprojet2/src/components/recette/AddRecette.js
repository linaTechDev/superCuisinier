import {useState} from 'react'
import GetIngredients from "./ingredient/GetIngredients";

const AddRecette = ({onAdd}) => {
    const [titre, setTitre] = useState('')
    const [portion, setPortion] = useState('')
    const [calories, setCalories] = useState('')
    const [ingredientDtos, setIngredientDtos] = useState([])

    const onSubmit = (e) => {
        e.preventDefault()

        if (
            !titre &&
            !portion &&
            !calories &&
            !ingredientDtos
        ) {
            alert('Ajouter une recette')
            return
        }

        if (
            !titre
        ) {
            alert('Ajouter un titre')
            return
        }

        if (
            !portion
        ) {
            alert('Ajouter une portion')
            return
        }

        if (
            !calories
        ) {
            alert('Ajouter les calories')
            return
        }

        if (
            !ingredientDtos
        ) {
            alert('Ajouter des ingrédients')
        }

        onAdd({
            titre,
            portion,
            calories,
            ingredientDtos
        })
        setTitre('')
        setPortion('')
        setCalories('')
        setIngredientDtos([])
    }

    return (
        <form className='add-form' onSubmit={onSubmit}>
            <div className='form-control'>
                <label>Titre</label>
                <input type='text' placeholder='Titre'
                       value={titre}
                       onChange={(e) => setTitre(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Portion</label>
                <input type='text' placeholder='Portion'
                       value={portion}
                       onChange={(e) => setPortion(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Calories</label>
                <input type='text' placeholder='Calories'
                       value={calories}
                       onChange={(e) => setCalories(e.target.value)}/>
            </div>
            <div className='form-control'>
                <label>Ingrédients</label>
                <GetIngredients
                    onChange={(e) => {
                        let ingredients = [e.length]
                        let n = 0
                        e.map((i) => {
                            let ingredient = {}
                            ingredient.id = i.value
                            ingredient.nom = i.label
                            ingredients[n] = ingredient
                            n++
                        })
                        setIngredientDtos(ingredients)
                    }}
                />
            </div>
            <input type='submit' value='Créer une nouvelle recette' className='btn btn-block bg-black text-light'/>
        </form>
    )
}

export default AddRecette
