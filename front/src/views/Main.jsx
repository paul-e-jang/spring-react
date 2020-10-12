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
        <Curation subject="AmazeMarket Top Sellers" />
        <Curation subject="Trending in Apperals" />
        <Curation subject="Popular Electronics" />
        <ProductRegister />
        </>
      )
    }
  
  }
  
  export default Main