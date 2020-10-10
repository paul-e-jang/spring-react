import React from 'react'
import '../css/footer.scss'
import eventBus from '../utils/eventBus'

class Footer extends React.Component {
  constructor(props) {
    super()
    this.state = {
      footerOn: true
    }
  }


  render() {
    const { footerOn } = this.state

    return (
      <footer>
        <div id ="footer" className={footerOn ? 'headerfooter-on' : 'headerfooter-off'}>
          <div id="back-to-top" onClick={this.handleScreenChange}>
            Back to top
          </div>
          <div id="about">
            <a href="/">
              <img src={require('../assets/logo_dark_h.svg')} alt="Logo" className="Logo" />
            </a>
          </div>
          <div id="footest">
          <ul>
            <li>Conditions of Use</li>
            <li>Privacy Notice</li>
            <li>Interest-Based Ads</li>
            <li className="copyright-wrapper"><span className="copyright"> <a href="http://github.com/bashpound/spring-react">© 2020 Bashpound, Blue-dragon Team or its affiliates </a></span></li>
            </ul>
          </div>
        </div>
      </footer>
    )
  }

  componentDidMount() {
    eventBus.on('headerFooter', (data) => this.setState({ footerOn: data.message }))
  }

  handleScreenChange = () => {
    window.scrollTo({
      top:0,
      behavior: 'smooth'
    })
  }
  


}

export default Footer
