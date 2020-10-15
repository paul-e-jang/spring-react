import React from 'react'
import qs from 'qs'
import productService from '../services/product'
import Product from '../comp/Product'


class SearchResult extends React.Component {

  constructor(props) {
    super()
    this.state = {
      plist: '',
      category: '',
      keyword: ''
    }
  }
  render() {

    const {plist, category, keyword} = this.state
    console.log(this.state.plist)
    const arr = []
    for (let i in plist) {
      arr.push(<Product props={plist[i]} />)
    }

    return (
      <section id="search-result">
        <div className="search-result-wrapper">
        <div className="search-result-header"><h1>Search Result for: {keyword===''? 'any' : keyword} {category===''? null : `in ${category}`} </h1>
        </div>
        {arr}
        <div className="search-resuilt-content"></div>
        </div>
      </section>
    )
  
  }

  componentDidUpdate(prevState) {
    if(prevState.category !== this.state.category || prevState.keyword !== this.state.keyword) {
      this.init()
    }
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
      this.setState({plist: data})
    })
  }

  componentDidMount() {
    this.init()
  }

}
export default SearchResult
