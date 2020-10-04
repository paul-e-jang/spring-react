import React from 'react'
import CounterContainer from './containers/CounterContainer'
import TodosContainer from './containers/TodosContainer'
import Header from './comp/Header'
import Login from './views/Login'
import MemberRegister from './views/MemberRegister'
import Footer from './comp/Footer'

import { Route } from 'react-router-dom'

function App() {
  return (
    <div>
      <Header />
      <Route path="/login" component={Login} exact={true} />
      <Route path="/register" component={MemberRegister} exact={true} />
      <CounterContainer />
        <hr />
      <TodosContainer />
      <Footer />
    </div>
  )
}

export default App