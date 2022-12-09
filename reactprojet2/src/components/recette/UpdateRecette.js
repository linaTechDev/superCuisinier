import {useEffect, useState} from 'react'
import GetIngredients from "./ingredient/GetIngredients";

const UpdateLivre = ({recette, onUpdate}) => {
    const [id, setId] = useState(0)
    const [titre, setTitre] = useState('')
    const [portion, setPortion] = useState('')
    const [calories, setCalories] = useState('')
    const [ingredientDtos, setIngredientDtos] = useState([])

    useEffect(() => {
        setId(recette.id)
        setTitre(recette.titre)
        setPortion(recette.portion)
        setCalories(recette.calories)
        setIngredientDtos(recette.ingredientDtos)
    }, [])

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

        onUpdate({
            id,
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
        <div className="updateRecette">
            <form className='add-form' onSubmit={onSubmit}>
                <div className='form-control updateRecette'>
                    <label>Titre</label>
                    <input type='text' placeholder='Titre'
                           value={titre}
                           onChange={(e) => setTitre(e.target.value)}/>
                </div>
                <div className='form-control updateRecette'>
                    <label>Portion</label>
                    <input type='text' placeholder='Portion'
                           value={portion}
                           onChange={(e) => setPortion(e.target.value)}/>
                </div>
                <div className='form-control updateRecette'>
                    <label>Calories</label>
                    <input type='text' placeholder='Calories'
                           value={calories}
                           onChange={(e) => setCalories(e.target.value)}/>
                </div>
                <div className='form-control updateRecette'>
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
                            console.log(ingredientDtos)
                        }}
                    />
                </div>
                <input type='submit' value='Mettre à jour une recette' className='btn btn-block bg-black text-light'/>
            </form>
        </div>
    )
}

export default UpdateLivre
