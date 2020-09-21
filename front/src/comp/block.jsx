import React from 'react'
import PropTypes from 'prop-types'

class Block extends React.Component {
  render() {
    const name = this.props.name
    return <div className="message-container">Hello {name} !</div>
  }
}

Block.propTypes = {
  name: PropTypes.string
}

export default Block
