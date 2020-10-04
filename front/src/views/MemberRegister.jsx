import React from 'react'
import {Label, Classes, Button} from "@blueprintjs/core"

class MemberRegister extends React.Component {
    render() {
      return (
        <>
        <div className="bp3-card">
            <h1>회원 가입</h1>
            <Label>
                <strong>아이디</strong>
                <input className={Classes.INPUT} placeholder="아이디" />
            </Label>
            <Label>
                <strong>이메일</strong>
                <input className={Classes.INPUT} placeholder="Email" />
            </Label>
            <Label>
            <strong>비밀번호</strong>
                <input className={Classes.INPUT} placeholder="비밀번호" type="password" />
            </Label>
            <Label>
            <strong>비밀번호 재입력</strong>
                <input className={Classes.INPUT} placeholder="비밀번호 재입력" type="password" />
            </Label>
            <Button className="bp3-fill"> 회원 가입 </Button><br/>
            <a href="/register">회원가입</a><br />
            <a href="/help">아이디/비밀번호 찾기</a> 
        </div>
        <div className="divider"><br /><br /><br /><br /></div>
        </>
      )
    }
  }
  
  export default MemberRegister