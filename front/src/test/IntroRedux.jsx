import React from 'react'
import CounterContainer from '../containers/CounterContainer'
import TodosContainer from '../containers/TodosContainer'

const style = {
    width: '500px',
    height: '50%',
    textAlign: 'left',
    margin: '5px auto',
    padding: '30px'
}

const IntroRedux = () => {
    return (
      <div style={style}>
        <CounterContainer />
        <hr />
        <TodosContainer />
      </div>
    )
}

export default IntroRedux
