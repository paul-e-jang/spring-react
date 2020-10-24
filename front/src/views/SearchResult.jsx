import React from 'react'
import qs from 'qs'
import productService from '../services/product'
import Product from '../comp/Product'
import '../css/content.scss'


class SearchResult extends React.Component {

  constructor(props) {
    super()
    this.state = {
      plist: [],
      category: '',
      keyword: '',
      prices: [],
      categories: [],
      maxPrice: '',
      minPrice: '',
      filtered: []
    }
  }
  render() {

    const {filtered, category, keyword, prices} = this.state
    console.log(filtered)

    const priceList = []
      for (let i=0; i<prices.length-1; i++) {
        priceList.push(<li key={i} onClick={() => this.filterByPrice(prices[i], prices[i+1])} >₩{this.AddComma(prices[i])}-{this.AddComma(prices[i+1])}</li>)
      }

    

    return (
      <>
      <section id="search-result">
        <div className="search-result-wrapper">
        <div className="search-result-header"><h1>Search Result for: {keyword===''? 'any' : keyword} {category===''? null : `in ${category}`} </h1>
        </div>
        <div className="search-result-content">
          <div className="search-result-side-bar" >
            <div className="side-bar-menu">{this.loadCategorySection()}</div>
            <div className="side-bar-menu"><h4>Filter by Price</h4> {priceList}</div>
            <hr></hr>
            <div className="side-bar-menu"><h4>Order by</h4> <li onClick={()=>this.orderBy('price desc')}>가격 높은 순</li> <li onClick={()=>this.orderBy('price asc')}>가격 낮은 순</li></div>

          </div>
          <div className="product">{this.loadProducts(filtered)}</div>
        </div>
        </div>
      </section>
      </>
    )
  
  }

  orderBy(arg) {
    const filtered = this.state.filtered
    const arr = []

    for(let i=0; i<filtered.length; i++){
      arr.push(filtered[i])
    }

    

    switch(arg){
      case 'price asc':
        arr.sort((a,b) => a.price-b.price)
        this.setState({filtered: arr})
        break
      case 'price desc':
        arr.sort((a,b) => b.price-a.price)
        this.setState({filtered: arr})
        break

      default:
        break
    }
  }

  loadCategorySection () {
    const categories = this.state.categories
    const categoryList = []
    for (let i=0; i<categories.length; i++) {
      categoryList.push(<li key={i} onClick={() => this.filterByName(categories[i])} >{categories[i]}</li>)
    }
    if(this.state.categories.length >=2){
      return <><h4>Category</h4> {categoryList} </>
    }
  }

  filterByPrice(min, max) {
    const arr = this.state.plist
    const res = []
    for(let i=0; i<arr.length; i++) {
      if(arr[i].price>=min && arr[i].price<=max ){
        res.push(arr[i])
      }
    }

    this.setState({filtered: res})
  }

  filterByName(name) {
    const arr = this.state.plist
    const res = []
    for(let i=0; i<arr.length; i++) {
      if(arr[i].category === name ){
        res.push(arr[i])
      }
    }

    this.setState({filtered: res})
  }

  loadProducts (arr) {
    const arrs = []
    for (let i in arr) {
      arrs.push(<Product props={arr[i]} key={i} />)
    }
    return arrs
  }

  AddComma(num)
  {
  const regexp = /\B(?=(\d{3})+(?!\d))/g
  return num.toString().replace(regexp, ',')
  }

  init () {
    const query = qs.parse(this.props.location.search, {
      ignoreQueryPrefix: true
    })

    const category = query.category
    const keyword = query.keyword
    
    
    this.setState({category: category})
    this.setState({keyword: keyword})
    

    productService.Search(keyword, category).then((data) => {
      
      let prices = [] 
      let categories = []

      for (let i=0; i<data.length; i++){
        prices.push(data[i].price)
        categories.push(data[i].category)
        categories = Array.from(new Set(categories))
        
      }
      
      prices.sort((a, b) => (a-b))
      let arr = []

      let i = 0
      
      while(i < data.length) {
        arr.push(prices[i])
        i += Math.floor(data.length/5)
      }

      arr.push(prices[data.length-1])
      
      this.setState({
        plist: data,
        prices: arr,
        categories: categories,
        filtered: data
      })
      
    })
  }

  componentDidMount() {
    this.init()
  }

}
export default SearchResult
