import React from 'react'
import { Link } from 'react-router-dom'
import '../css/content.scss'

type ItemsProp = {
  subject: string
  image: string
  message: string
}


class CarouselItems extends React.PureComponent<ItemsProp> {

  render() {
    const {subject, image, message} = this.props

    const url: string = 'http://localhost:8090/static/carousel/' + image

    return (
      <>
        <div id="carousel-items">
          <div className="wrapper">
            <h2>{subject}</h2>
            <div className="img-wrapper" >
            <img src={url} alt="API서버를 찾을 수 없습니다."/>
            </div>
            <div>
              <Link to="/" className="show-more">{message}</Link>
            </div>
          </div>
        </div>
      </>
    )
  }

}

export default CarouselItems
