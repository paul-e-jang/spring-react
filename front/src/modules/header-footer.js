
const HEADER = 'Header/HEADER'
const FOOTER = 'Footer/FOOTER'


export const header = () => ({ type: HEADER })
export const footer = () => ({ type: FOOTER })



const initialState = {
    header: true,
    footer: true
}

function headerFooter(state = initialState, action) {
    switch(action.type){
        case HEADER:
            return{
                header: !header
            }
        case FOOTER:
            return{
                footer: !footer
            }
        default:
            return state
    }
}

export default headerFooter