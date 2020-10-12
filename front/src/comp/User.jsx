import React from 'react'
import authentication from '../utils/authentication'
import eventBus from '../utils/eventBus'

class User extends React.Component {
  
  constructor(props)  {
    super(props)
    this.state = { name: 'anonymous' }
    this.loginSession = React.createRef()
  }
  render() {
    const {name} = this.state

    return (
      <div ref={this.loginSession}> {name} </div>
    )
  }

  componentDidMount = () => {
    authentication.fetchUser().then(()=> {
      eventBus.on("fetchUser", (data) =>
      this.setState({ name: data.message })
    )
    })
    eventBus.dispatch('loginSession', { message: 'user' })
  }
}