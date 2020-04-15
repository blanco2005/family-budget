import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import MonthlyBudget from './App';
import * as serviceWorker from './serviceWorker';

fetch(`/monthlybudget/current`)
  .then(result => result.json())
  .then(response => {
    console.log(response)
    let categories = response.categories2budget;
    console.log(categories)
    //console.log(typeof categories)
    ReactDOM.render(
      <MonthlyBudget categories={categories}/>
      , document.getElementById('root'));
});

// ReactDOM.render(
//     <MonthlyBudget />,
//     document.getElementById('root')
// );



// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
