import React from 'react'
import '../css/content.scss'

type ItemsProp = {
  subject: string
  image: string
  message: string
  category: string
}


class CarouselItems extends React.PureComponent<ItemsProp> {

  render() {
    const {subject, image, message, category} = this.props

    const url: string = 'http://localhost:8090/static/carousel/' + image

    return (
      <>
        <div id="carousel-items">
          <div className="wrapper">
            <h2>{subject}</h2>
            <div className="img-wrapper" >
            <a href={`/searchResult?category=${category}&keyword=`} ><img src={url} alt="API서버를 찾을 수 없습니다."/></a>
            </div>
            <div>
            <a href={`/searchResult?category=${category}&keyword=`} className="show-more">{message}</a>
            </div>
          </div>
        </div>
      </>
    )
  }

}

export default CarouselItems
