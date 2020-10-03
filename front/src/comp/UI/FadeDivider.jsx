import React from 'react'

const fade_rule = {
    height: '1px',
    backgroundColor: '#E6E6E6',
    width: '66.0em',
    margin: '0 auto',
    backgroundImage: 'linear-gradient(left , white 2%, #E6E6E6 50%, white 98%)',
}

class FadeDivider extends React.Component {
    render() {
      return (
        <>
        <div style={fade_rule}>
        </div>
        </>
      )
    }
  }
  
  export default FadeDivider