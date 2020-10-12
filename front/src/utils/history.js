import { useHistory } from 'react-router-dom'


export default function handlePush(param) {
  let history = useHistory()
  history.push(param)
}
