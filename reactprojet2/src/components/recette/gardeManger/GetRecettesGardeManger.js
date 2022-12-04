import {useEffect} from "react";

const GetRecettesGardeManger = ({gardeManger, onRecettes, recettes}) => {

    const onDiv = (e) => {
        e.preventDefault()

        onRecettes({
            gardeManger
        })
    }
    return (
        <div className="recettesGardeManger" onMouseOver={onDiv}>
            <p>{recettes.titre}</p>
        </div>
    )
}
export default GetRecettesGardeManger
