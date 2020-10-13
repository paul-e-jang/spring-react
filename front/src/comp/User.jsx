import React from 'react'
import eventBus from '../utils/eventBus'
import authenticationService from '../services/authentication'

class User extends React.Component {
  
  constructor(props)  {
    super(props)
    this.state = { name: 'anonymous' }
  }
  render() {

    return (
      <></>
    )
  }

  
  componentDidMount = () => {
    const currentUser = authenticationService.fetchUser()
    console.log(currentUser)

      eventBus.on("fetchUser", (data) => {
        this.setState({ name: data })
        console.log(data)
      }
    )
  }
  
}

export default User