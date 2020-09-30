import React from 'react'
import { Route } from 'react-router-dom'
import About from './comp/About'
import Home from './comp/Home'

function App() {
  return (
    <div>
      <Route path="/" component={Home} />
      <Route path="/about" component={About} />
    </div>
  )
}

export default App
