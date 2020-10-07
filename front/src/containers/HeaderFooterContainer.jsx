import React from 'react'
import {connect} from 'react-redux'
import Header from '../comp/Header'
import Footer from '../comp/Footer'
import {header, footer} from '../modules/header-footer'

const HeaderFooterContainer = ({header, footer}) => {
    return (
        <>
    <Header header={header} />
    <Footer footer={footer}/>
    </>
    )
}

const mapStatetoProps = state => ({
    header: state.counter.header,
    footer: state.counter.footer
})

const mapDispatchToProps = dispatch => ({
    header: () =>{
        dispatch(header())
    },
    footer: () => {
        dispatch(footer())
    }
})

export default connect(
    mapStatetoProps,
    mapDispatchToProps,
)(HeaderFooterContainer)