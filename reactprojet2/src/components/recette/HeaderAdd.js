import PropTypes from 'prop-types'
import Button from './Button'


const HeaderAdd = ({title, onAdd, showAdd}) => {

    return (
        <header className='header2'>
            <h1>{title}</h1>
            <Button color={showAdd ? 'red' : 'green'}
                    text={showAdd ? 'Close' : 'Add'} onClick={onAdd}/>
        </header>
    )
}

HeaderAdd.defaultProps = {
    title: 'Trask Tracker',
}

HeaderAdd.propTypes = {
    title: PropTypes.string.isRequired,
}

export default HeaderAdd
