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

class Cart extends React.Component {
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
          <h1>Shopping Cart</h1>
          <Button icon="delete" intent="danger">
                    모두 삭제
        </Button>
       <Button icon="dollar" style={margin} intent="success">
                    체크아웃
        </Button>
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
                  <Popover
                    interactionKind={PopoverInteractionKind.CLICK}
                    popoverClassName="bp3-popover-content-sizing"
                    position={Position.TOP}
                  >
                    <Button intent={Intent.NONE} icon="changes">
                      수량 바꾸기
                    </Button>
                    <div className="popover-option">
                      <p>수량을 입력하세요.</p>
                      <NumericInput
                        intent={Intent.WARNING}
                        min={1}
                        max={100}
                        onValueChange={this.handleValueChange}
                        placeholder="5"
                      />
                    </div>
                  </Popover>
                  <Button icon="trash" style={margin}>
                    삭제
                  </Button>
                </div>
              </div>
            </div>
          </Card>

          <Card className="cart-total" interactive elevation={Elevation.THREE}>
            <h2>총 가격:<br /> 1000</h2>
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

export default Cart
