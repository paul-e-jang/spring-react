import React from 'react'
import NavigationDrawer from './UI/NavigationDrawer'
import '../css/Header.css'

class Header extends React.Component {
  render() {
    return (
      <>
        <header>
            <div class="flex">
            <NavigationDrawer />
                <div class="logo">
                    <a href="/"><img src="../assets/logo.svg" alt="Logo" /></a>
                </div>
                <nav>
                    <input type="text"></input>
                    <ul id="nav-menu-container">
                        <li><a href="/">Accounts/Lists</a></li>
                        <li><a href="/">Returns/Order</a></li>
                        <li><a href="/">Cart</a></li>
                    </ul>
                </nav>
                
                <a href="/" id="login-register-button">Login / Register</a>
            </div>
        </header>
      </>
    )
  }
}

export default Header
