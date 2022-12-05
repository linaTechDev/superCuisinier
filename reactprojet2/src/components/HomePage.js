import React from "react";
import {Link} from "react-router-dom";
import "./HomePage.css"

const HomePage = () => (
    <div className='fondAccueil'>
        <h1 className='titre'>Super Cuisinier</h1>
        <div className='menu'>
            <Link to="/recette"><h2 className='recette'>Recette</h2></Link>
            <Link to="/gardeManger"><h2 className='gardeManger'>Garde-manger</h2></Link>
        </div>
    </div>
)

export default HomePage;
