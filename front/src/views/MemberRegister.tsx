import React from 'react'
import { Intent, InputGroup, FormGroup, Label, Button } from "@blueprintjs/core"
import { usernameRegex, emailRegex, passwordRegex } from '../utils/regex'
import eventBus from '../utils/eventBus'
import { Link } from 'react-router-dom'
import '../css/form.scss'
import RegistrationService from '../services/RegistrationService'
import { RouteComponentProps } from 'react-router-dom'


interface RegisterGroupState {
    username: string;
    isUsernameValid: string;
    password: string;
    isPasswordValid: string;
    password2: string;
    isPassword2Valid: string;
    emailAddress: string;
    isEmailAddressValid: string;
    isOnLoad: boolean;
    isButtonDisabled: boolean;
}



class MemberRegister extends React.PureComponent<RouteComponentProps, RegisterGroupState> {

    public state: RegisterGroupState =  {
        username: '',
        isUsernameValid: 'no-val',
        password: '',
        isPasswordValid: 'no-val',
        password2: '',
        isPassword2Valid: 'no-val',
        emailAddress: '',
        isEmailAddressValid: 'no-val',
        isOnLoad: false,
        isButtonDisabled: false
    }

    

    render() {
        const {isOnLoad} = this.state

        return (
            <section className="login-register">
                <div id="logo">
                    <Link to="/"><img src={require('../assets/logo_white_h.svg')} alt="Logo"/></Link>
                </div>
                <FormGroup disabled={isOnLoad}>
                    <div className="bp3-card">
                        <h1>회원 가입</h1>
                        <Label className="input-wrapper">
                            <strong>아이디</strong>
                            <InputGroup name="username" placeholder="영대/소문자/숫자 2~20자" intent={this.IntentParser(this.state.isUsernameValid)}
                            onChange={(e: React.ChangeEvent<HTMLInputElement>) => this.setState({ username: e.target.value, isUsernameValid: usernameRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isUsernameValid}`}>아이디는 영대/소문자 or 숫자 포함 2~20글자 입니다.</h5>
                            </Label>
                        </Label>
                        <Label className="input-wrapper">
                            <strong>이메일</strong>
                            <InputGroup name="emailAddress" placeholder="Email" intent={this.IntentParser(this.state.isEmailAddressValid)}
                            onChange={(e: React.ChangeEvent<HTMLInputElement>)=> this.setState({ emailAddress: e.target.value, isEmailAddressValid: emailRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isEmailAddressValid}`}>유효하지 않은 이메일 형식 입니다.</h5>
                            </Label>
                        </Label>
                        <Label className="input-wrapper">
                            <strong>비밀번호</strong>
                            <InputGroup name="password" placeholder="대/소문자 ,숫자 특수문자 하나 이상 포함 8자 이상" type="password"
                            intent={this.IntentParser(this.state.isPasswordValid)}
                            onChange={(e: React.ChangeEvent<HTMLInputElement>)=> this.setState({ password: e.target.value, isPasswordValid: passwordRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isPasswordValid}`}>비밀번호는 대/소문자/숫자/특수문자 포함 8자 이상입니다.</h5>
                            </Label>
                        </Label>

                        <Label className="input-wrapper">
                            <strong>비밀번호 재입력</strong>
                            <InputGroup name="password2" placeholder="비밀번호 재입력" type="password" intent={this.IntentParser(this.state.isPassword2Valid)}
                            onKeyPress={this.handleKeyPress}
                            onChange={(e: React.ChangeEvent<HTMLInputElement>)=> this.setState({ password2: e.target.value, isPassword2Valid: this.state.password === e.target.value ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isPassword2Valid}`}>비밀번호가 일치하지 않습니다.</h5>
                            </Label>
                        </Label>
                        <Button large
                        className="bp3-fill"
                        id="register-button"
                        onClick={this.handleRegister}
                        disabled={!this.SubmitPreventer()}
                        loading={isOnLoad}
                        >
                        
                        회원 가입 </Button>
                    </div>
                </FormGroup>
            </section>
        )
    }

    IntentParser = (state: string) => {
        switch(state){
            case 'invalid':
                return Intent.DANGER

            case 'valid':
                return Intent.SUCCESS

            default:
                return Intent.NONE
        }
    }

    SubmitPreventer = () => {
        return this.state.isUsernameValid ==='valid' &&
        this.state.isPasswordValid ==='valid' &&
        this.state.isPassword2Valid ==='valid'&&
        this.state.isEmailAddressValid ==='valid'
    }

    componentDidMount = () => {
    eventBus.dispatch('headerFooter', { message: false })
    }

    componentWillUnmount = () => {
        eventBus.dispatch('headerFooter', { message: true })
        eventBus.remove('headerFooter')
    }

    handleKeyPress = (e: any) => {
        if(e.key === "Enter"){
          this.handleRegister()
        }
    }

    handleRegister = () => {
        const f = new FormData()
        f.append('username', this.state.username)
        f.append('password', this.state.password)
        f.append('emailAddress', this.state.emailAddress)
        const json = JSON.stringify(Object.fromEntries(f))
        this.setState({isOnLoad: true})

        RegistrationService.MemberRegister(json).then(({history}) => {
          alert('등록 성공')
          this.setState({isOnLoad: false})
          this.props.history.push('/login')
        }).catch((error) => {
            alert('등록 실패, 이유: '+error.message)
            this.setState({isOnLoad: false})
        })
      }
}

export default MemberRegister