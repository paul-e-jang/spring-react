import React from 'react'
import Header from './comp/Header'
import Footer from './comp/Footer'
import './App.css'
import Content from './views/Content'
import { FocusStyleManager } from '@blueprintjs/core'
 
FocusStyleManager.onlyShowFocusOnTabs()


function App() {
  return (
    <div id="app">
      <Header />
      <Content />
      <Footer />
    </div>
  )
}


export default App