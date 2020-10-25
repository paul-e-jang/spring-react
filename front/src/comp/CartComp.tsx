import React, {Component} from 'react'
import '../css/base.scss'
import { Icon } from "@blueprintjs/core"
import ProductService from '../services/product'
//import {Link } from 'react-router-dom'

interface CartCompGroupState {
  total: number;
  displayOn: boolean;
  products: Array<any>
}

interface cartProps {
  username?: string
}


class CartComp extends Component<cartProps, CartCompGroupState> {
    
    constructor(props: cartProps){
      super(props)
      this.state = {
        products: [],
        total: 0,
        displayOn: false
      }
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
      if(this.props.username !== 'anonymous'){
      ProductService.getCart(this.props.username).then((data)=>{
        console.log(data)
      }).catch((e)=>{
        alert(e)
      })
    }
    }

    componentWillUnmount = () => {
      
    }
}
  export default CartComp