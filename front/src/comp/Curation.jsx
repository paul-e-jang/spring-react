import React from 'react'
import AliceCarousel from 'react-alice-carousel'
import 'react-alice-carousel/lib/alice-carousel.css'
import '../css/content.scss'
import {Link} from 'react-router-dom'

const style = { width: 300 }

const items = [
    <div className="item" style={style}>1</div>,
    <div className="item" style={style}>2</div>,
    <div className="item" style={style}>3</div>,
    <div className="item" style={style}>4</div>,
    <div className="item" style={style}>5</div>
]

const Curation = ({subject}) => (
    <section id="curation">
    <div className="session-wrapper">
    <div className="subject"> {subject} <Link to="/" className="link show-more">Shop now</Link> </div>
    <AliceCarousel
        mouseTracking
        items={items}
        disableDotsControls
        autoWidth
        infinite
    />
    </div>
    </section>
)

export default Curation