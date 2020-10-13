import React from 'react'
import ImageGallery from 'react-image-gallery'
import CarouselItems from './CarouselItems'
import CarouselItemsButton from './CarouselItemsButton'
import '../css/content.scss'
import eventBus from '../utils/eventBus'

class Carousel extends React.Component {
    constructor(props) {
      super()
      this.state = {
        currentUser: 'anonymous'
      }
    }
  
    render() {
    const images = [
            {
              original: 'http://localhost:8090/static/carousel/1.jpg'
            },
            {
              original: 'http://localhost:8090/static/carousel/2.jpg'
            },
            {
              original: 'http://localhost:8090/static/carousel/3.jpg'
            },
            {
                original: 'http://localhost:8090/static/carousel/4.jpg'
            }
          ]
    const loginSign = (
      <CarouselItemsButton subject="Sign in for the best experience" message="see more" />
    )

    const fourth = (
      <CarouselItems subject="Home furnitures" image="sub_4.jpg" message="see more" />
    )

    const { currentUser} = this.state


      return (
        <section id="carousel">
        <ImageGallery
        items={images}
        showFullscreenButton={false}
        showThumbnails={false}
        showPlayButton={false}
        infinite
        />
        <div id="carousel-items-wrapper">
        <CarouselItems subject="Clothes" image="sub_1.jpg" message="see more"/>
        <CarouselItems subject="Amazon Basics" image="sub_2.jpg" message="see more" />
        <CarouselItems subject="Electronics" image="sub_3.jpg" message="see more" />
        {currentUser === 'anonymous' ? loginSign : fourth}
        </div>
        </section>
      )
      
    }
  
    componentDidMount() {
      eventBus.on("fetchUser", (data) => {
          this.setState({ currentUser: data })
          console.log(data)
        }
      )
    }
    
  }
  
  export default Carousel