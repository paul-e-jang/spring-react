import React from 'react'
import { NumericInput, HTMLSelect, InputGroup, FormGroup, Label, Button, FileInput} from "@blueprintjs/core"
import { Link } from 'react-router-dom'
import '../css/form.scss'
import RegistrationService from '../services/RegistrationService'


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
                
            </section>
        )
    }
}