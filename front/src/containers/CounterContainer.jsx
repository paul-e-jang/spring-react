import React from 'react'
import {connect} from 'react-redux'
import Counter from '../test/Counter'
import {increase, decrease} from '../modules/counter'

const CounterContainer = ({number, increase, decrease}) => {
    return (
    <Counter number={number} onIncrease={increase} onDecrease = {decrease} />
    )
}

const mapStatetoProps = state => ({
    number: state.counter.number
})

const mapDispatchToProps = dispatch => ({
    increase: () => {
        dispatch(increase())
    },
    decrease: () =>{
        dispatch(decrease())
    }
})

export default connect(
    mapStatetoProps,
    mapDispatchToProps,
)(CounterContainer)