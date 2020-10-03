import React from 'react'
import CounterContainer from './containers/CounterContainer'
import TodosContainer from './containers/TodosContainer'
import Header from './comp/Header'
import Login from './views/Login'

function App() {
  return (
    <div>
      <Header />
      <Login />
      <CounterContainer />
        <hr />
      <TodosContainer />
    </div>
  )
}

export default App