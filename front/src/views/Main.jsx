import React from 'react'
import ProductRegister from '../comp/ProductRegister'
import Carousel from '../comp/Carousel'
import '../css/base.scss'

class Main extends React.Component {
    constructor(props) {
      super()
      this.state = {
      }
    }
  
  
    render() {
    
      return (
        <>
        <Carousel />
        <ProductRegister />
        </>
      )
    }
  
  }
  
  export default Main