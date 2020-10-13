import React from 'react'
import '../css/base.scss'
import { Icon } from "@blueprintjs/core"
//import {Link } from 'react-router-dom'

interface CartCompGroupState {
  //products: Array<any>;
  total: number;
  displayOn: boolean;
}


class CartComp extends React.PureComponent<CartCompGroupState> {

    public state: CartCompGroupState = {
     // products: [],
      total: 0,
      displayOn: true
    }


    render() {

      const { total, displayOn } = this.state;

      const totalPrice = (
        <div>
         Subtotal:<br /> <h5 className="bp3-heading">₩{total}</h5>
        </div>
      )

      const caret = (
        <div className="cart-arrow"><Icon icon="caret-left" iconSize={20} className={displayOn? 'display-on': 'display:off'} /> </div>
      )

      return (
        <aside className={displayOn? 'display-on' : 'display-off'}>
          <div className="cart-wrapper">
            <div className="cart-header">
                {displayOn ? caret : null}
              <div className='cart-total' > {totalPrice} </div>
            </div>
            <div className="cart-content">
            Products
            </div>
            <div className="cart-content">
            Products
            </div>
          </div>
        </aside>
      )
    }

    componentDidMount = () => {
      
    }

    componentWillUnmount = () => {
      
    }
}
  export default CartComp