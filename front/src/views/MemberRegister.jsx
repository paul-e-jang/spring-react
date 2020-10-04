import React from 'react'
import {Label, Classes, Button} from "@blueprintjs/core"

class MemberRegister extends React.Component {

    constructor(props){
        super()
        this.state = {
          username: '',
          password: '',
          password2: '',
          emailAddress: '',
        }
        this.handleChange = this.handleChange.bind(this)
      }

    handleValid = (state) => this.setState({ state: true })
    handleInvalid = (state) => this.setState({ state: false })

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    
    render() {
      return (
        <section>
            <form>
            <div className="bp3-card">
                <h1>회원 가입</h1>
                <Label>
                    <strong>아이디</strong>
                    <input className={Classes.INPUT} name="username" placeholder="아이디" value={this.state.useranme} onChange={this.handleChange}/>
                <Label>
                    <h5>아이디는 영대/소문자 or 숫자 포함 2~20글자 입니다.</h5>
                </Label>
                </Label>
                <Label>
                    <strong>이메일</strong>
                    <input className={Classes.INPUT} name="emailAddress" placeholder="Email" value={this.state.emailAddress} />
                <Label>
                    <h5>유효하지 않은 이메일 형식 입니다.</h5>
                </Label>
                </Label>
                <Label>
                <strong>비밀번호</strong>
                    <input className={Classes.INPUT} name="password1" placeholder="비밀번호" type="password" value={this.state.password} />
                <Label>
                    <h5>비밀번호는 대/소문자/특수문자 포함 8~24자 입니다.</h5>
                </Label>
                </Label>

                <Label>
                <strong>비밀번호 재입력</strong>
                    <input className={Classes.INPUT} name="password2" placeholder="비밀번호 재입력" type="password" />
                <Label>
                    <h5>비밀번호가 일치하지 않습니다.</h5>
                </Label>
                </Label>

                <Button className="bp3-fill"> 회원 가입 </Button><br/>
                <a href="/register">회원가입</a><br />
                <a href="/help">아이디/비밀번호 찾기</a> 
            </div>
            <div className="divider"><br /><br /><br /><br /></div>
            </form>
        </section>
      )
    }
  }
  
  export default MemberRegister