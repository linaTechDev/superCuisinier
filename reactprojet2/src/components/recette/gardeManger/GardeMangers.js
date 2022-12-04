import GardeManger from "./GardeManger";

const GardeMangers = ({gardeMangers, onDelete, onUpdate, showUpdate}) => {
    return (
        <>
            {gardeMangers.map((gardeManger) => (
                <GardeManger
                    key={gardeManger.id}
                    gardeManger={gardeManger}
                    onDelete={onDelete}
                    onUpdate={onUpdate}
                    showUpdate={showUpdate}/>
            ))}
        </>
    )
}

export default GardeMangers
