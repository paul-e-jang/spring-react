import React from 'react'

const Product = ({props}) => (
    <>
      <img src={`http://localhost:8090/static/upload/${props.category}/${props.thumbNail}`} alt="이미지 로딩 실패"/>
      <h1>ProductName: {props.name} </h1>
      <h2>price: {props.price} </h2>
      <h3>stock: {props.stock} , id: {props.id}</h3>
    </>
)

export default Product