import React from "react";
import Category from "../category/Category";
import './style.css'

const monthlyBudgetPage = (props) => {
  return (
      <div>
        <div className="monthly-budget-page">
          <h1 style={{marginTop:50}}>Budget of {props.month} {props.year}</h1>
          {
            props.categories.map((category, index) =>
                <Category name={category.name} budget={category.money} key={index}/>
            )
          }
        </div>
      </div>
  )
}

export default monthlyBudgetPage;