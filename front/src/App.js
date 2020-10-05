import React from 'react'
import Header from './comp/Header'
import Login from './views/Login'
import MemberRegister from './views/MemberRegister'
import Footer from './comp/Footer'
import IntroRedux from './test/IntroRedux'
import Main from './views/Main'
import './App.css'

import { Route } from 'react-router-dom'

function App() {
  return (
    <div id="app">
      <Header />
      <Route path="/login" component={Login} exact={true} />
      <Route path="/register" component={MemberRegister} exact={true} />
      <Route path="/test" component={IntroRedux} exact={true} />
      <Route path="/" component={Main} exact={true} />
      <Footer />
    </div>
  )
}

export default App