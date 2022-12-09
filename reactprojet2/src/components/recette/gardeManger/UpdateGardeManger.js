import {useEffect, useState} from 'react'
import GetIngredients from "./../ingredient/GetIngredients";
import "./PageGardeManger.css"

const UpdateGardeManger = ({gardeManger, onUpdate}) => {
    const [id, setId] = useState(0)
    const [nom, setNom] = useState('')
    const [ingredientDtos, setIngredientDtos] = useState([])

    useEffect(() => {
        setId(gardeManger.id)
        setNom(gardeManger.nom)
        setIngredientDtos(gardeManger.ingredientDtos)
    }, [])

    const onSubmit = (e) => {
        e.preventDefault()

        if (
            !nom &&
            !ingredientDtos
        ) {
            alert('Ajouter un garde-manger')
            return
        }

        if (
            !nom
        ) {
            alert('Ajouter un nom au garde-manger')
            return
        }

        if (
            !ingredientDtos
        ) {
            alert('Sélectionner des ingrédients pour le garde-manger')
            return
        }

        onUpdate({
            id,
            nom,
            ingredientDtos
        })
        setNom('')
        setIngredientDtos([])
    }

    return (
        <div className="gardeMangerFondUpdate">
            <form className='add-form' onSubmit={onSubmit}>
                <div className='form-control gardeMangerFondUpdate'>
                    <label>Nom</label>
                    <input type='text' placeholder='Nom'
                           value={nom}
                           onChange={(e) => setNom(e.target.value)}/>
                </div>
                <div className='form-control gardeMangerFondUpdate'>
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
                <input type='submit' value='Mettre à jour le garde-manger' className='btn btn-block bg-black text-light'/>
            </form>
        </div>
    )
}

export default UpdateGardeManger
