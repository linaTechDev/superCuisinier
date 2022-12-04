import React, {useEffect, useState} from "react";
import HeaderAdd from "../HeaderAdd";
import AddGardeManger from "./AddGardeManger";
import GardeMangers from "./GardeMangers";
import UpdateGardeManger from "./UpdateGardeManger";
import {Link} from "react-router-dom";
import { FaToggleOff } from 'react-icons/fa'

const PageGardeManger = () => {
    const [showAddGardeManger, setShowAddGardeManger] = useState(false)
    const [showUpdateGardeManger, setShowUpdateGardeManger] = useState(false)
    const [showRecettesGardeManger, setShowRecettesGardeManger] = useState(false)
    const [gardeMangers, setGardeMangers] = useState([])
    const [gardeManger, setGardeManger] = useState({})
    const [recettes, setRecettes] = useState([])

    useEffect(() => {
        const getGardeMangers = async () => {
            const gardeMangersFromServer = await fetchGardeMangers()
            setGardeMangers(gardeMangersFromServer)
        }
        getGardeMangers()
    }, [])

    const fetchGardeMangers = async () => {
        const res = await fetch('http://localhost:8080/gardeManger')
        const data = await res.json()
        return data
    }

    const fetchRecettesGardeManger = async (id) => {
        const res = await fetch(`http://localhost:8080/gardeManger/ingredient/${id}`)
        const data = await res.json()
        console.log(data)
        setRecettes(data)
        setShowRecettesGardeManger(!showRecettesGardeManger)
        return data
    }

    const addGardeManger = async (gardeManger) => {
        const res = await fetch('http://localhost:8080/gardeManger',
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify(gardeManger)
            })
        const data = await res.json()
        setGardeMangers([...gardeMangers, data])
    }

    const deleteGardeManger = async (id) => {
        await fetch(`http://localhost:8080/gardeManger/${id}`, {
            method: 'DELETE'
        })
        setGardeMangers(gardeMangers.filter((gardeManger) => gardeManger.id !== id))
    }

    const updateGardeManger = async (gardeManger) => {
        console.log(gardeManger)
        const res = await fetch(`http://localhost:8080/gardeManger/${gardeManger.id}`, {
            method: 'PUT',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify(gardeManger)
        })
        const data = await res.json()
        setGardeMangers(
            gardeMangers.map(
                (g) => g.id === gardeManger.id ?
                    {...gardeManger,
                        nom: data.nom,
                        ingredientDtos: data.ingredientDtos
                    } : g
            )
        )
    }

    return (
        <div className='container'>
            <h1>Garde-manger</h1>
            <p><Link to="/accueil">Retour à l'accueil</Link></p>
            {gardeMangers.length === 0 ?
                <HeaderAdd
                onAdd={() =>
                    setShowAddGardeManger(!showAddGardeManger)}
                showAdd={showAddGardeManger}/>
                : 'Il y a déjà un garde-manger'
            }
            {gardeMangers.length === 0 ?
                showAddGardeManger &&
                <AddGardeManger onAdd={addGardeManger} />
                : <FaToggleOff
                    style={{color: 'red', cursor: 'pointer'}}/>
            }
            <p>Pour Mettre à jour un garde-manger, double click sur un garde-manger</p>
            {showUpdateGardeManger && <UpdateGardeManger gardeManger={gardeManger} onUpdate={updateGardeManger} />}
            {gardeMangers.length > 0 ?
                <GardeMangers
                    gardeMangers={gardeMangers}
                    recettes={recettes}
                    onDelete={deleteGardeManger}
                    onUpdate={(gardeManger) => {
                        setShowUpdateGardeManger(!showUpdateGardeManger)
                        setGardeManger(gardeManger)
                    }}
                    onRecettes={fetchRecettesGardeManger}
                    showRecettes={showRecettesGardeManger}
                    showUpdate={showUpdateGardeManger}
                />
                : 'No garde-manger'}
        </div>
    );
}

export default PageGardeManger
