import React from 'react'
import { Route, Switch } from 'react-router-dom'
import Main from './Main'
import Login from './Login'
import MemberRegister from './MemberRegister'
import SearchResult from './SearchResult'
import CsMain from './CsMain'
import ProductDetail from './ProductDetail'
import Cart from './Cart'
import MyPage from './MyPage'

const Content = () => (
    <main>
        <Switch>
        <Route path="/login" component={Login} exact={true} />
        <Route path="/register" component={MemberRegister} exact={true} />
        <Route path="/" component={Main} exact={true} />
        <Route path="/searchResult" component={SearchResult} exact={false} />
        <Route path="/CsMain" component={CsMain} exact={true} />
        <Route path="/productDetail/" component={ProductDetail} exact={false} />
        <Route path="/cart/" component={Cart} exact={false} />
        <Route path="/mypage/" component={MyPage} exact={false} />
        </Switch>
    </main>
)


export default Content