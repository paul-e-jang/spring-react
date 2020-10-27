import React from 'react'
import AuthenticationService from '../services/authentication'
import ProductService from '../services/product'
import '../css/content.scss'
import {
  Button,
  NumericInput,
  Intent,
  Popover,
  PopoverInteractionKind,
  Position,
  Card,
  Elevation 
} from '@blueprintjs/core'

class Mypage extends React.Component {
  constructor() {
    super()
    this.state = {
      username: 'anonymous',
      items: [],
    }
  }

  render() {
    const margin = { marginLeft: '10px' }
    return (
      <section id="cart">
        <div className="cart-header">
        <br />
          <h1>Recent purchase</h1>
        </div>
        
        <div className="cart-wrapper">
          <Card className="cart-item" elevation={Elevation.TWO}>
            <div className="cart-item-container">
              <span>
                <img
                  src="http://localhost:8090/static/carousel/sub_3.jpg"
                  className="item-image"
                  alt=""
                />
              </span>
              <div className="item-content">
                <h2 className="item-name">
                  Duracell Optimum AAA Batteries Resealable Package for Storage, 18 Count (Pack of 1)
                </h2>
                <div className="item-stock">
                  <h3>수량: 100</h3>
                  <h3>판매자: jchan</h3>
                  <h3>등록일: 등록일</h3>
                </div>
                <div className="handle-option">
                  <Button style={margin}>
                    상품평 등록
                  </Button>
                </div>
              </div>
            </div>
          </Card>
        </div>
      </section>
    )
  }

  componentDidMount() {
    AuthenticationService.fetchUser()
      .then((data) => {
        this.setState({ username: data.username })
      })
      .catch((error) => alert(error))

    ProductService.getCart(this.state.username)
      .then((data) => {
        this.setState({ items: data })
      })
      .catch((error) => alert(error))
  }
}

export default Mypage
