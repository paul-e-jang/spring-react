import React from 'react'
import '../css/footer.scss'

class Footer extends React.Component {
  render() {
    return <div id="footer">
    <div id="back-to-top"><h5>Back to top</h5></div>
    <div id="about"><a href="/"><img src={require('../assets/logo_dark_h.svg')} alt="Logo" className="Logo" /></a></div>
    <div id="sitemap"><h5>Something!</h5></div>
    </div>
  }
}

export default Footer
