import Utilisateur from "./Utilisateur";
import React from "react";

const Utilisateurs = ({utilisateurs}) => {
    return (
        <>
            <tbody>
                {React.Children.toArray(
                    utilisateurs.map((utilisateur) => <Utilisateur />))}
            </tbody>
        </>
    )
}

export default Utilisateurs
