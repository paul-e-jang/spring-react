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
          <div id="back-to-top">
            <h5>Back to top</h5>
          </div>
          <div id="about">
            <a href="/">
              <img src={require('../assets/logo_dark_h.svg')} alt="Logo" className="Logo" />
            </a>
          </div>
          <div id="sitemap">
            <h5>Something!</h5>
          </div>
        </div>
      </footer>
    )
  }

  componentDidMount() {
    eventBus.on('headerFooter', (data) => this.setState({ footerOn: data.message }))
  }
  


}

export default Footer
