import React from 'react'
import ProductRegister from '../comp/ProductRegister'
import Carousel from '../comp/Carousel'
import '../css/base.scss'
import Curation from '../comp/Curation'

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
        <Curation />
        <ProductRegister />
        </>
      )
    }
  
  }
  
  export default Main