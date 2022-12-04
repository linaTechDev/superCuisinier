import React, {useEffect, useState} from "react";
import HeaderAdd from "../HeaderAdd";
import AddGardeManger from "./AddGardeManger";
import GardeMangers from "./GardeMangers";
import UpdateGardeManger from "./UpdateGardeManger";
import {Link} from "react-router-dom";

const PageGardeManger = () => {
    const [showAddGardeManger, setShowAddGardeManger] = useState(false)
    const [showUpdateGardeManger, setShowUpdateGardeManger] = useState(false)
    const [gardeMangers, setGardeMangers] = useState([])
    const [gardeManger, setGardeManger] = useState({})

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
            <HeaderAdd title='Garde-manger'
                       onAdd={() =>
                           setShowAddGardeManger(!showAddGardeManger)}
                       showAdd={showAddGardeManger}/>
            <p><Link to="/accueil">Retour à l'accueil</Link></p>
            {showAddGardeManger && <AddGardeManger onAdd={addGardeManger} />}
            <p>Pour Mettre à jour un garde-manger, double click sur un garde-manger</p>
            {gardeMangers.length > 0 ?
                <GardeMangers gardeMangers={gardeMangers}
                          onDelete={deleteGardeManger}
                          onUpdate={(gardeManger) => {
                              setShowUpdateGardeManger(!showUpdateGardeManger)
                              setGardeManger(gardeManger)
                          }}
                          showUpdate={showUpdateGardeManger}
                />
                : 'No garde-manger'}
            {showUpdateGardeManger && <UpdateGardeManger gardeManger={gardeManger} onUpdate={updateGardeManger} />}
        </div>
    );
}

export default PageGardeManger
