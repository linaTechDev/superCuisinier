import {useEffect, useState} from "react";
import Select from 'react-select'

const AddIngredients = ({onChange}) => {
    const [selectOptions, setSelectOptions] = useState([])
    const [value, setValue] = useState([])

    useEffect(() => {
        const getOptions = async () => {
            const optionsFromServer = await fetchOptions()
            const options = optionsFromServer.map(d => ({
                "value": d.id,
                "label": d.nom
            }))
            setSelectOptions(options)
        }
        getOptions()
    }, [])

    const fetchOptions = async () => {
        const res = await fetch('http://localhost:8080/ingredient')
        const data = await res.json()
        return data
    }

    const handleChange = (e) => {
        setValue(e)
        console.log(value)
    }

    return (
        <div>
            <Select
                options={selectOptions}
                onChange={(event) => {
                    handleChange.bind(event)
                    onChange(event)
                }}
                isMulti />
        </div>
    )
}

export default AddIngredients
