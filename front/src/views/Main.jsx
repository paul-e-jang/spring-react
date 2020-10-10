import React from 'react'
import { HTMLSelect, InputGroup, FormGroup, Label, Button, FileInput} from "@blueprintjs/core"
import { Link } from 'react-router-dom'
import '../css/form.scss'
import RegistrationService from '../services/RegistrationService'
import history from '../utils/history'


export default class MemberRegister extends React.Component {

    constructor(props) {
        super()
        this.state = {
            productName: '',
            thumbImage: '',
            thumbUrl: 'noUrl',
            username: 'null (로딩 실패)',
            stock: '',
            price: '',
            category: ''
        }
    }

    
    render() {
      const {productName, thumbImage, thumbUrl, username, stock, price, category} = this.state
      
        return (
            <section id="product-register">
                <div id="logo">
                    <Link to="/"><img src={require('../assets/logo_white_h.svg')} alt="Logo"/></Link>
                </div>
                <FormGroup>
                    <div className="bp3-card">
                        <h1>상품 등록(임시)</h1>
                        <Label className="input-wrapper">
                            <strong>상품명</strong>
                            <InputGroup name="username" placeholder="상품명" onChange={e => this.setState({ productName: e.target.value })} />
                        </Label>
                            <FileInput text="썸네일" onChange={this.onChangeImages} />
                            <div id="image-wrapper">
                            <img src={thumbUrl} alt="미리보기" className={thumbUrl==='noUrl'? 'no-val': 'invalid'}/>
                            </div>
                        <Label className="input-wrapper">
                            <strong>판매자: {username}</strong>
                        </Label>
                        <Label className="input-wrapper">
                            <strong>재고량</strong>
                            <InputGroup name="username" placeholder="재고량" onChange={e => this.setState({ stock: e.target.value })} />
                        </Label>
                        <Label className="input-wrapper">
                            <strong>가격</strong>
                            <InputGroup name="username" placeholder="가격" onChange={e => this.setState({ price: e.target.value })}/>
                        </Label>
                        <Label className="input-wrapper">
                            <strong>카테고리</strong>
                            <HTMLSelect value={this.state.category} onChange={e => this.setState({ category: e.target.value })}>
                              <option defaultValue>카테고리를 선택하세요</option>
                              <option value="의류">의류</option>
                              <option value="가전">가전</option>
                              <option value="전자기기">전자기기</option>
                              <option value="식품">식품</option>
                            </HTMLSelect>
                        </Label>
                        <h2>데이터 검증</h2>
                        productName: {productName} <br/>
                        thumbImage: {thumbImage.name}<br/>
                        username: {username}<br/>
                        stock: {stock}<br/>
                        price: {price}<br/>
                        category: {category}<br/>
                        
                        <Button large className="bp3-fill" id="register-button"> 상품 등록 </Button>
                    </div>
                </FormGroup>
            </section>
        )
    }

    onChangeImages = (e) => {
        const file = e.target.files[0]
        this.setState({thumbImage: file})
        this.setState({thumbUrl: URL.createObjectURL(file)})
        const fm = new FormData()
        fm.append('image', file)
      }

    SubmitPreventer = () => {
        return this.state.isUsernameValid ==='valid' &&
        this.state.isPasswordValid ==='valid' &&
        this.state.isPassword2Valid ==='valid'&&
        this.state.isEmailAddressValid ==='valid'
    }

    handleRegister = () => {
        const f = new FormData()
        f.append('productName', this.state.productName)
        f.append('thumbImage', this.state.thumbImage.name)
        f.append('stock', this.state.stock)
        f.append('price', this.state.price)
        f.append('category', this.state.category)
        f.append('username', this.state.username)
        const json = JSON.stringify(Object.fromEntries(f))
        RegistrationService.productRegister(json).then(() => {
          alert('등록 성공')
          history.push('/')
        }).catch((error) => {
          alert('등록 실패'+error.message)
        })
    }
}