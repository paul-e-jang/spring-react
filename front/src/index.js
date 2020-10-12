import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom'
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import 'normalize.css/normalize.css';
import '@blueprintjs/core/lib/css/blueprint.css'
import axios from 'axios'

axios.defaults.baseURL = '/api'
axios.defaults.headers.common.Accept = 'application/json'
axios.defaults.headers.post['Content-Type'] = 'application/json'
axios.interceptors.response.use(
  response => response,
  (error) => {
    return Promise.reject(error)
  }
)

ReactDOM.render(
      <BrowserRouter>
       <App />
       </BrowserRouter>
    ,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
