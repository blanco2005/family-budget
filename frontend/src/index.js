import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Layout from './layout/Layout'
import * as serviceWorker from './serviceWorker';

fetch(`/monthlybudget/current`)
  .then(result => result.json())
  .then(response => {
    let categories = response.categories2budget;

    // ReactDOM.render(
    //   <MonthlyBudget categories={categories}/>
    //   , document.getElementById('root'));
    ReactDOM.render(
      <Layout month="April" year="2020" categories={categories} />,
      document.getElementById('root')
    );
  }
  );


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
