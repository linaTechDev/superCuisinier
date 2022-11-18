import {Component} from "react";
import Select from 'react-select'
import axios from "axios";

export default class AddIngredients extends Component {

    constructor(props) {
        super(props);
        this.state = {
            selectOptions : [],
            value:[]
        }
    }

    async getOptions() {
        const res = await axios.get('http://localhost:8080/ingredient')
        const data = res.data
        const options = data.map(d => ({
            "value": d.id,
            "label": d.nom
        }))

        this.setState({selectOptions: options})
    }

    handleChange(e) {
        this.setState({value:e})
    }

    componentDidMount(){
        this.getOptions()
    }

    render() {
        return (
            <div>
                <Select
                    options={this.state.selectOptions}
                    onChange={(event) => {
                        this.handleChange.bind(event)
                        this.props.onChange(event)
                    }}
                    isMulti />
            </div>
        )
    }
}
