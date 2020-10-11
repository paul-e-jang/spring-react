import React from 'react'
import AliceCarousel from 'react-alice-carousel'
import 'react-alice-carousel/lib/alice-carousel.css'
import '../css/content.scss'

const responsive = {
    0: { items: 1 },
    568: { items: 2 },
    1024: { items: 3 },
};

const items = [
    <div className="item">1</div>,
    <div className="item">2</div>,
    <div className="item">3</div>,
    <div className="item">4</div>,
    <div className="item">5</div>,
];

const Curation = () => (
    <section id="curation">
    <AliceCarousel
        mouseTracking
        items={items}
        responsive={responsive}
        paddingLeft={50}
        paddingRight={50}
        disableDotsControls
    />
    </section>
)

export default Curation