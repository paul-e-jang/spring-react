import axios from 'axios'
import errorParser from '../utils/error-parser'

export default {
  /**
   * Register a new user
   * @param {Object} detail registration detail
   */
  MemberRegister (detail) {
    return new Promise((resolve, reject) => {
      axios.post('/MemberRegister', detail).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },

  productRegister (detail) {
    return new Promise((resolve, reject) => {
      axios.post('/ProductRegister', detail).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
