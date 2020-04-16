import React from "react";
import './style.css'
import MonthlyBudgetPage from "../page/MonthlyBudgetPage";

const main = (props) => {

  return (
      <div className="main" id='contentContainer'>
        <MonthlyBudgetPage month={props.month} year={props.year} categories={props.categories}/>
      </div>
  )
}

export default main;