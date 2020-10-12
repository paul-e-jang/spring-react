import axios from 'axios'
import errorParser from '../utils/error-parser'

export default {
Upload (detail) {
    return new Promise((resolve, reject) => {
      axios({
        method: 'post',
        url: '/fileUpload',
        data: detail,
        headers: {
          'content-type': 'multipart/form-data',
          Accept: 'multipart/form-data'
        }
      }).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
}

}