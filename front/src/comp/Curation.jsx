import React from 'react'
import AliceCarousel from 'react-alice-carousel'
import 'react-alice-carousel/lib/alice-carousel.css'
import '../css/content.scss'
import {Link} from 'react-router-dom'

class Curation extends React.Component {

    constructor() {
      super()
      this.state = {
        currentUser: 'anonymous'
      }
    }

    render() {
        const{subject, items, responsive, url} = this.props

        return(
            <section id="curation">
                <div className="session-wrapper">
                <div className="subject"> {subject} <Link to={url} className="link show-more">Shop now</Link> </div>
                <AliceCarousel
                    items={items}
                    disableDotsControls
                    infinite
                    responsive={responsive}
                />
                </div>
            </section>
        )
    }

}




export default Curation