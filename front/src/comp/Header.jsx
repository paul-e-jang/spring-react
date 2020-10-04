import React from 'react'
import NavigationDrawer from './UI/NavigationDrawer'
import '../css/header.scss'
import { Link } from 'react-router-dom'

class Header extends React.Component {
  render() {
    return (
      <>
        <header id="header">
          <div id="upper-bar">
            <div id="drawer">
              <NavigationDrawer />
            </div>
            <a href="/"><img src={require('../assets/logo_dark.svg')} alt="Logo" className="Logo" /></a>
            <input className="search-bar" type="text"></input>
            <nav>
              <ul id="nav-menu-container">
                <li>
                  <a href="/">Accounts/Lists</a>
                </li>
                <li>
                  <a href="/">Returns/Order</a>
                </li>
                <li>
                  <a href="/">Cart</a>
                </li>
              </ul>
            </nav>
            <Link to="login">Login / Register</Link>
          </div>
          <div id="under-bar"><h3>Our Response to COVID-19</h3></div>
        </header>
      </>
    )
  }
}

export default Header
