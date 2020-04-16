import React from 'react'
import Header from './Header'
import Main from './Main'

const layout = (props) => {
    return (
        <div id='layoutContainer'>
            <Header />
            <Main month={props.month} year={props.year} categories={props.categories}/>
        </div>
    )
}

export default layout;