import React from "react";
import PageRecette from "./recette/PageRecette";
import {Link} from "react-router-dom";

let img = 'https://www.mesinspirationsculinaires.com/wp-content/uploads/2020/04/recette-ramadan-2020-1-620x330.jpg'

const HomePage = () => (
    <div>
        <h2><Link to="/recette">Recette</Link></h2>
        <img src={img} alt="recette"/>
    </div>
)

export default HomePage;
