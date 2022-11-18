import { useEffect, useState} from "react";
import Ingredients from "./Ingredients";
import React from "react";
import "./../../../style.css";

const PageIngredient = () => {

    const [ingredients, setIngredients] = useState([])

    useEffect(() => {
        const getIngredients = async () => {
            const ingredientsFromServer = await fetchIngredients()
            setIngredients(ingredientsFromServer)
        }
        getIngredients()
    }, [])

    const fetchIngredients = async () => {
        const res = await fetch('http://localhost:8080/ingredient')
        return await res.json()
    }

    return (
        <div className='container'>
            <Ingredients ingredients={ingredients}/>
        </div>
    );
}

export default PageIngredient
