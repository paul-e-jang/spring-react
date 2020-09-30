import React from 'react'
import { Route, Link } from 'react-router-dom'
import About from './comp/About'
import Home from './comp/Home'
import History from './comp/History'

function App() {
  return (
    <div>
      <ul>
        <li>
          <Link to ="/">홈</Link>
        </li>
        <li>
          <Link to ="/about">소개</Link>
        </li>
        <li>
          <Link to="/history">History </Link>
        </li>
      </ul>
      <hr />
      <Route path="/" component={Home} exact={true} />
      <Route path="/about" component={About} />
      <Route path="/history" component={History} />
    </div>
  )
}

export default App