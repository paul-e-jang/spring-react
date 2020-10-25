import React from 'react'
import '../css/content.scss'


class ProductDetail extends React.PureComponent {


  render() {
    const {product, subject} = this.props
    const url = `http://localhost:8090/static/upload/${product.category}/${product.thumbNail}`

    return (
      <section id="product-detail">
        <div>
          <div className="wrapper">
            <h2>{subject}</h2>
            <div className="img-wrapper" >
            <a href={`/searchResult?category=${product.category}&keyword=`} ><img src={url} alt="API서버를 찾을 수 없습니다."/></a>
            </div>
          </div>
        </div>
      </section>
    )
  }

}

export default ProductDetail
