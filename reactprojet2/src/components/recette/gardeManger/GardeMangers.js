import GardeManger from "./GardeManger";

const GardeMangers = ({gardeMangers, recettes, onDelete, onUpdate, onRecettes, showRecettes, showUpdate}) => {
    return (
        <>
            {gardeMangers.map((gardeManger) => (
                <GardeManger
                    key={gardeManger.id}
                    gardeManger={gardeManger}
                    recettes={recettes}
                    onDelete={onDelete}
                    onUpdate={onUpdate}
                    onRecettes={onRecettes}
                    showRecettes={showRecettes}
                    showUpdate={showUpdate}/>
            ))}
        </>
    )
}

export default GardeMangers
