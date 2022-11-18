import {useEffect, useState} from 'react'

const UpdateLivre = ({recette, onUpdate}) => {
    const [id, setId] = useState(0)
    const [titre, setTitre] = useState('')
    const [portion, setPortion] = useState('')
    const [calories, setCalories] = useState('')

    useEffect(() => {
        setId(recette.id)
        setTitre(recette.titre)
        setPortion(recette.portion)
        setCalories(recette.calories)
    }, [])

    const onSubmit = (e) => {
        e.preventDefault()

        if (
            !titre &&
            !portion &&
            !calories
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

        onUpdate({
            id,
            titre,
            portion,
            calories
        })
        setTitre('')
        setPortion('')
        setCalories('')
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
            <input type='submit' value='Mettre à jour une recette' className='btn btn-block bg-black text-light'/>
        </form>
    )
}

export default UpdateLivre
