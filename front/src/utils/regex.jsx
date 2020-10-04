import React from 'react'
import {Label} from "@blueprintjs/core"

const emailRegex = /^(([^<>()[].,;:\s@"]+(.[^<>()[].,;:\s@"]+)*)|(".+"))@(([^<>()[].,;:\s@"]+.)+[^<>()[].,;:\s@"]{2,})$/i
const usernameRegex = /^[a-z0-9_]{2,20}$/
const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/

export function isValidEmail(email) {
  return emailRegex.test(email) ? 
    <Label>
    <h5>유효하지 않은 이메일 형식 입니다.</h5>
    </Label>
    : null;
}

export function isValidUsername(username) {
  return usernameRegex.test(username) ?
  <Label>
  <h5>아이디는 영대/소문자 or 숫자 포함 2~20글자 입니다.</h5>
  </Label>
  : null;
}

export function isValidPassword(password) {
  return passwordRegex.test(password) ?
  <Label>
  <h5>비밀번호는 대/소문자/특수문자 포함 8~24자 입니다.</h5>
  </Label>
  : null;
}

export function isSamePassword(password1, password2) {
  return password1 === password2 ?
  <Label>
  <h5>비밀번호가 일치하지 않습니다.</h5>
  </Label>
  : null;
}

