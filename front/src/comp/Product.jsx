import React  from 'react'
import '../css/content.scss'
import { NumericInput , Card, Button, Classes, Tooltip , AnchorButton, Intent, Dialog, Toaster, Position } from '@blueprintjs/core'
import ProductService from '../services/product'

class Product extends React.Component {

  constructor(){
    super()
    this.state = {
      isOpen: false,
      value: 1,
      disabled: false,
      disabled2: false
    }
  }

  render() {
    const {props} = this.props
    const { disabled, disabled2} = this.state
    const style = {'width' : '100%', 'padding': '10px', }
    const pStyle = { 'marginTop' : '10px' }
    

  return (
  <>
    <Card interactive={true} className="product-item" onClick={this.handleOpen}>
      <img src={`http://localhost:8090/static/upload/${props.category}/${props.thumbNail}`} alt="이미지 로딩 실패"/>
      <h4>ProductName: {props.name} </h4>
      <h2>price: ₩{AddComma(props.price)} </h2>
    </Card>
    <Dialog
        icon="inbox-search"
        onClose={()=>this.handleClose()}
        title="상품 상세 정보"
        canOutsideClickClose={false}
        {... this.state}
        
    >
        <div className={Classes.DIALOG_BODY} style={style}>
        <div id="product-detail-img">
        <img src={`http://localhost:8090/static/upload/${props.category}/${props.thumbNail}`} alt="이미지 로딩 실패"/>
        </div>
        <NumericInput intent={Intent.WARNING} min={1} max={props.stock} onValueChange={this.handleValueChange}  placeholder="구매수량을 입력하세요" />
            <p style={pStyle}>
                <strong>
                    <li>상품명: {props.name}</li>
                    <li>가격: ₩{AddComma(props.price)}</li>
                    <li>재고: {props.stock}</li>
                    <li>판매자: {props.seller === null? '미등록(null)' : props.stock}</li>
                </strong>
            </p>
            <p>
                상품 설명이 원래는 등록 되어 있어야 하는데 시간상 생략하였읍니다. <br />
                동적으로 입력이 가능합니다.<br />
                그 증거로 이 상품의 등록일은 {props.regDate} <br />
            </p>
            <strong>- Written by Bashpound </strong>
        </div>
        
        <div className={Classes.DIALOG_FOOTER}>
            <div className={Classes.DIALOG_FOOTER_ACTIONS}>
                <Tooltip content="클릭하면 창이 닫힙니다.">
                    <Button onClick={()=>this.handleClose} disabled={disabled}>닫기</Button>
                </Tooltip>
                <AnchorButton
                    intent={Intent.PRIMARY}
                    onClick={()=>this.handleCartIn(props.id)}
                    disabled={disabled}
                    loading={disabled}
                >
                    {'장바구니 담기'}
                </AnchorButton>
                <Tooltip content="장바구니에 담지 않고 바로 결제">
                <AnchorButton
                    intent={Intent.SUCCESS}
                    disabled={disabled}
                    loading={disabled2}
                    onClick={()=>this.handleDirectPurchase()}
                >
                    바로 구매!
                </AnchorButton>
                </Tooltip>
            </div>
        </div>
    </Dialog>
  </>
  )
}
  handleOpen  = () => this.setState({isOpen: true})
  handleClose  = () => this.setState({isOpen: false})
  handleValueChange = (_valueAsNumber, valueAsString) => {
    this.setState({ value: valueAsString })
  }
  handleCartIn =  (id) => {
    console.log('pid: ' +id)
    const f = new FormData()
    f.append('pid', id)
    f.append('numberOfItems', this.state.value)
    f.append('uid', 'eunhackjang')
    this.setState({disabled: true})
    const json = JSON.stringify(Object.fromEntries(f))
    console.log(json)
    ProductService.addToCart(json).then(()=>{
      this.setState({disabled: false})
      alert('등록 성공!')
      this.setState({isOpen: false})
    }).catch((error)=>{
      alert(error)
      this.setState({disabled: false})
    })

  }

  handleDirectPurchase = () => {
    const id = this.props.id    
    const f = new FormData()
    f.append('pid', id)
    f.append('numberOfItems', this.state.value)
    f.append('uid', 'eunhackjang')
    f.append('is_purchased', true)
    this.setState({disabled2: true})
    const json = JSON.stringify(Object.fromEntries(f))
    ProductService.purchase(json).then((data)=>{
      this.setState({disabled2: false})
      this.toastShow('구매에 성공하였습니다. ㅋㅋ')
      this.setState({isOpen: false})
    }).catch((error)=>{
      this.toastShow(error)
      this.setState({disabled2: false})
    })
  }

  toastShow(message) {
    const pop = Toaster.create({
      intent: Intent.DANGER,
      position: Position.TOP,
  })
    pop.show({message: message})
  }
  
}



function AddComma(num)
{
const regexp = /\B(?=(\d{3})+(?!\d))/g
return num.toString().replace(regexp, ',')
}

export default Product