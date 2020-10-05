import React from 'react'
import {Label, InputGroup,  Button} from "@blueprintjs/core"
import {Link} from 'react-router-dom'
import '../css/form.scss'

class Login extends React.Component {

    constructor(props){
      super()
      this.state = {
        username: '',
        password: ''
      }
    }

    handleChange(e) {
      this.setState({
        [e.target.name]: e.target.value
      })
    }

    render() {
      return (
        <section>
          <div id="logo">
                    <img src={require('../assets/logo_white_h.svg')} alt="Logo"/>
          </div>
          <form>
          <div className="bp3-card">
              <h1>로그인</h1>
              <Label>
                  <strong>아이디 or Email</strong>
                  <InputGroup placeholder="아이디 or Email을 입력하세요." onChange={e => this.setState({ username: e.target.value})} />
              </Label>
              <Label>
              <strong>비밀번호</strong>
                  <InputGroup placeholder="비밀번호를 입력하세요." type="password" onChange={e => this.setState({ password: e.target.value})}  />
              </Label>
              <Button large disabled={!this.SubmitPreventer()} className="bp3-fill"> 로그인 </Button><br/>
              <Link to="/register">회원가입</Link><br />
              <a href="/help">아이디/비밀번호 찾기</a> 
          </div>
          <div className="divider"><br /><br /><br /><br /></div>
          </form>
        </section>
      )
    }

    SubmitPreventer = () => {
      return this.state.username.length >= 2 && this.state.password.length >= 8
  }
  }
  
  export default Login