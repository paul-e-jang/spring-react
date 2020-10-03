import React from 'react'
import CounterContainer from './containers/CounterContainer'
import TodosContainer from './containers/TodosContainer'
import NavigationDrawer from './comp/UI/NavigationDrawer'

function App() {
  return (
    <div>
      <CounterContainer />
        <hr />
      <TodosContainer />
      <NavigationDrawer />

    </div>
  )
}

export default App