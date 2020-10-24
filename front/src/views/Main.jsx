import React from 'react'
//import ProductRegister from '../comp/ProductRegister'
import Carousel from '../comp/Carousel'
import '../css/base.scss'
import Curation from '../comp/Curation'
import productService from '../services/product'

class Main extends React.Component {
    constructor(props) {
      super()
      this.state = {
        plist: [],
        elec: [],
        clothes: []
      }
    }
  
  
    render() {
      const {plist, elec, clothes} = this.state
      const responsive = {
        0: { items: 1 },
        500: { items: 2 },
        1000: { items: 3 },
        1500: { items: 4 },
        2000: { items: 5 },
      }
    
      return (
        <>
        <Carousel />
        <Curation subject="AmazeMarket Top Sellers" items={plist} responsive={responsive} url={`/searchResult?category=&keyword=`} />
        <Curation subject="Popular Electronics" items={clothes} responsive={responsive} url={`/searchResult?category=의류&keyword=`}/>
        <Curation subject="Trending in Apperals" items={elec} responsive={responsive} url={`/searchResult?category=가전&keyword=`}/>
        </>
      )
    }
    
    componentDidMount () {
      this.init()
    }
    
    shuffle(a) {
      a.sort(()=>Math.random()-0.5)
    }

    init () {
      
      const elec = []
      const clothes = []
      const plist = []
      

      productService.Search('', '').then((data) => {

        for(let i=0; i<data.length; i++){
          if(data[i].category==='의류'){
            elec.push(
              <div className="item" >
                <img src={`http://localhost:8090/static/upload/${data[i].category}/${data[i].thumbNail}`} alt="이미지 로딩 실패"/>
              </div>
            )
            plist.push(
              <div className="item" >
                <img src={`http://localhost:8090/static/upload/${data[i].category}/${data[i].thumbNail}`} alt="이미지 로딩 실패"/>
              </div>
            )
          }
          if(data[i].category==='가전'){
            clothes.push(
              <div className="item" >
                <img src={`http://localhost:8090/static/upload/${data[i].category}/${data[i].thumbNail}`} alt="이미지 로딩 실패"/>
              </div>
            )
            plist.push(
              <div className="item" >
                <img src={`http://localhost:8090/static/upload/${data[i].category}/${data[i].thumbNail}`} alt="이미지 로딩 실패"/>
              </div>
            )
          }
        }

        this.shuffle(elec)
        this.shuffle(clothes)
        this.shuffle(plist)
        
          this.setState({
            elec: elec,
            clothes: clothes,
            plist: plist
          })
      })
  }

  }
  
  export default Main