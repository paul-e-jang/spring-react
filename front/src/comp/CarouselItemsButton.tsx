import React from 'react'
import { Link } from 'react-router-dom'
import '../css/content.scss'
import { Button } from '@blueprintjs/core'

type ItemsProp = {
  subject: string
  message: string
}

class CarouselItemsButton extends React.PureComponent<ItemsProp> {
  render() {
    const { subject} = this.props

    return (
      <>
        <div id="carousel-items">
          <div className="wrapper">
            <h2>{subject}</h2>
            <div className="img-wrapper">
              <div className="button-wrapper">
                <Link to="/login"><Button fill>로그인</Button></Link>
              </div>
            </div>
            <div>
              <br />
            </div>
          </div>
        </div>
      </>
    )
  }
}

export default CarouselItemsButton
