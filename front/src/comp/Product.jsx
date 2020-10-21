import React from 'react'
import '../css/content.scss'
import {Card} from '@blueprintjs/core'

const Product = ({props}) => (
    <Card interactive={true} className="product-item">
      <img src={`http://localhost:8090/static/upload/${props.category}/${props.thumbNail}`} alt="이미지 로딩 실패"/>
      <h4>ProductName: {props.name} </h4>
      <h2>price: ₩{AddComma(props.price)} </h2>
    </Card>
)

function AddComma(num)
{
const regexp = /\B(?=(\d{3})+(?!\d))/g
return num.toString().replace(regexp, ',')
}

export default Product