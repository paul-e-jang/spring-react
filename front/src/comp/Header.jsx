import React from 'react'
import NavigationDrawer from './UI/NavigationDrawer'
import '../css/header.scss'
import { Link } from 'react-router-dom'
import Banner from './Banner'
import eventBus from '../utils/eventBus'
import SearchBar from './UI/SearchBar'
import User from './User'

class Header extends React.Component {

  constructor(props) {
    super()
    this.state = {
      headerOn: true,
      currentUser: 'anonymous'
    }
}

  render() {
    const {headerOn, currentUser} = this.state

    return (
        <header id="header" className={headerOn? 'headerfooter-on': 'headerfooter-off'}>
          <User />
         
          <div id="upper-bar">
            <div id="drawer">
              <NavigationDrawer />
            </div>
            <a href="/">
              <img id="banner" src={require('../assets/logo_dark.svg')} alt="Logo" className="Logo" />
            </a>
            <SearchBar />
            <nav className="upper-bar-right">
              <ul id="nav-menu-container">
                <li>
                  <Link to={currentUser === 'anonymous' ? '/login' : '/'}>
                    <Banner main={`Hello, ${currentUser === 'anonymous' ? 'sign-in' : currentUser}`} sub="Accounts & Lists" />
                  </Link>
                </li>
                <li>
                  <a href="/">
                    <Banner main="Returns" sub="& Orders" />
                  </a>
                </li>
                <li>
                  <a href="/">
                    <Banner main="Cart" />
                  </a>
                </li>
              </ul>
            </nav>
          </div>
          <div id="under-bar">
            <div className="under-banner">
               <Link to="/"><Banner sub="Delivery to: Somewhere!"/></Link> 
            </div>
            <div className="under-banner">
               <Link to="/"><Banner main="Today's Deals" /></Link> 
            </div>
            <div className="under-banner">
            <Link to="/CsMain"><Banner main="Customer Service" /></Link> 
            </div>
            <div className="under-banner">
            <Link to="/"><Banner main="Sell" /></Link> 
            </div>
              <h3 className="under-banner covid">Our Response to COVID-19</h3>
          </div>
        </header>
    )
  }

  componentDidMount() {
    console.log('currentUser = ' + this.state.currentUser)
    eventBus.on("fetchUser", (data) => {
        this.setState({ currentUser: data })
        console.log(data)
      }
    )

    eventBus.on("headerFooter", (data) =>
      this.setState({ headerOn: data.message })
    )
    document.title = 'Amaze Market'
    /* authentication.fetchUser().then(()=> {
      eventBus.on("fetchUser", (data) =>
      this.setState({ user: data.message })
    )
    }) */
  }
}

export default Header
