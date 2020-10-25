import axios from 'axios'
import errorParser from '../utils/error-parser'

export default {

  Search (key, category) {
    return new Promise((resolve, reject) => {
      axios.get(`/SearchResult?key=${key}&category=${category}`).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  writeProduct (detail) {
    return new Promise((resolve, reject) => {
      axios({
        method: 'post',
        url: '/writeProduct',
        data: detail,
        headers: { 'content-type': 'application/json' }
      }).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  fileUpload (detail) {
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
  },
  addToCart (detail) {
    return new Promise((resolve, reject) => {
      axios.post('/addToCart', detail).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  purchase (detail) {
    return new Promise((resolve, reject) => {
      axios.post('/purchase', detail).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
