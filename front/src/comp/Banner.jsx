import React from 'react'



const banner = ({main, sub}) => {
    return (
        <div id="banner">
            <div>{main}</div>
            <h4>{sub}</h4>
        </div>
        
    )
}

export default banner