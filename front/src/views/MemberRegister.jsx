import React from 'react'
import { Label, Classes, Button } from "@blueprintjs/core"
import { usernameRegex, emailRegex, passwordRegex } from '../utils/regex'

export default class MemberRegister extends React.Component {

    constructor(props) {
        super()
        this.state = {
            username: '',
            isUsernameValid: 'no-val',
            password: '',
            isPasswordValid: 'no-val',
            password2: '',
            isPassword2Valid: 'no-val',
            emailAddress: '',
            isEmailAddressValid: 'no-val'
        }
    }

    render() {
        return (
            <section>
                <form>
                    <div className="bp3-card">
                        <h1>회원 가입</h1>
                        <Label>
                            <strong>아이디</strong>
                            <input className={Classes.INPUT} name="username" placeholder="영대/소문자/숫자 2~20자"
                            onChange={e => this.setState({ username: e.target.value, isUsernameValid: usernameRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isUsernameValid}`}>아이디는 영대/소문자 or 숫자 포함 2~20글자 입니다.</h5>
                            </Label>
                        </Label>
                        <Label>
                            <strong>이메일</strong>
                            <input className={Classes.INPUT} name="emailAddress" placeholder="Email"
                            onChange={e => this.setState({ emailAddress: e.target.value, isEmailAddressValid: emailRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isEmailAddressValid}`}>유효하지 않은 이메일 형식 입니다.</h5>
                            </Label>
                        </Label>
                        <Label>
                            <strong>비밀번호</strong>
                            <input className={Classes.INPUT} name="password1" placeholder="대/소문자 ,숫자 특수문자 하나 이상 포함 8자 이상" type="password"
                            onChange={e => this.setState({ password: e.target.value, isPasswordValid: passwordRegex.test(e.target.value) ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isPasswordValid}`}>비밀번호는 대/소문자/숫자/특수문자 포함 8자 이상입니다.</h5>
                            </Label>
                        </Label>

                        <Label>
                            <strong>비밀번호 재입력</strong>
                            <input className={Classes.INPUT} name="password2" placeholder="비밀번호 재입력" type="password"
                            onChange={e => this.setState({ password2: e.target.value, isPassword2Valid: this.state.password === e.target.value ? 'valid' : 'invalid' })} />
                            <Label>
                                <h5 className={`${this.state.isPassword2Valid}`}>비밀번호가 일치하지 않습니다.</h5>
                            </Label>
                        </Label>

                        <Button className="bp3-fill"> 회원 가입 </Button><br />
                        <a href="/register">회원가입</a><br />
                        <a href="/help">아이디/비밀번호 찾기</a>
                    </div>
                    <div className="divider"><br /><br /><br /><br /></div>
                </form>
            </section>
        )
    }

}