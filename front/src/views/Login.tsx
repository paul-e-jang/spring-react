import React from 'react'
import {FormGroup, Label, InputGroup,  Button, Tooltip, Intent} from "@blueprintjs/core"
import {Link} from 'react-router-dom'
import '../css/form.scss'

interface LoginGroupState {
  username: string;
  password: string;
  showPassword: boolean;
  disabled: boolean;
}


class Login extends React.PureComponent<LoginGroupState> {
  
  public state: LoginGroupState = {
    username: '',
    password: '',
    showPassword: false,
    disabled: false,
  }

    render() {

      const { showPassword, disabled } = this.state;

      const lockButton =  (
        <Tooltip content={`${showPassword ? "Hide" : "Show"} Password`} disabled={disabled}>
            <Button
                disabled={disabled}
                icon={showPassword ? "unlock" : "lock"}
                intent={Intent.WARNING}
                minimal={true}
                onClick={this.handleLockClick}
            />
        </Tooltip>
    )
      return (
        
        <section>
          <div id="logo">
                    <img src={require('../assets/logo_white_h.svg')} alt="Logo"/>
          </div>
          <FormGroup>
          <div className="bp3-card">
              <h1>로그인</h1>
              <Label className="input-wrapper">
                  <strong>아이디 or Email</strong>
                  <InputGroup placeholder="아이디 or Email을 입력하세요."
                  onChange={ (e: React.ChangeEvent<HTMLInputElement>)  => this.setState({ username: e.target.value})} />
              </Label>
              <Label className="input-wrapper">
              <strong>비밀번호</strong>
                  <InputGroup
                    disabled={disabled}
                    placeholder="비밀번호를 입력하세요."
                    rightElement={lockButton}
                    type={showPassword ? "text" : "password"}
                    onChange={(e: React.ChangeEvent<HTMLInputElement>) => this.setState({ password: e.target.value})}
                />
              </Label>
              <Button large id="login-button" disabled={!this.SubmitPreventer()} className="bp3-fill"> 로그인 </Button><br/>
              <Link to="/register">회원가입</Link><br />
              <a href="/help">아이디/비밀번호 찾기</a> 
          </div>
          <div className="divider"><br /><br /><br /><br /></div>
          </FormGroup>
        </section>
      )
    }

    SubmitPreventer = () => {
      return this.state.username.length >= 2 && this.state.password.length >= 8
    }

    handleLockClick = () => this.setState({ showPassword: !this.state.showPassword })
  }
  
  export default Login