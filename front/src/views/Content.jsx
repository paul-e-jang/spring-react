import React from 'react'
import { Route, Switch } from 'react-router-dom'
import Main from './Main'
import Login from './Login'
import MemberRegister from './MemberRegister'
import SearchResult from './SearchResult'

const Content = () => (
    <main>
        <Switch>
        <Route path="/login" component={Login} exact={true} />
        <Route path="/register" component={MemberRegister} exact={true} />
        <Route path="/" component={Main} exact={true} />
        <Route path="/searchResult" component={SearchResult} exact={true} />
        </Switch>
    </main>
)


export default Content