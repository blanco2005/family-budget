import React from 'react';
import './index.css';
import Category from "./Category/Category";

class MonthlyBudget extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      month: `April`,
      year: `2020`
    }
  }

  render() {
    return (
        <div className="monthly-budget">
          <h1>Budget of {this.state.month} {this.state.year}</h1>
          <Category name="Benzina" budget="120" />
          <Category name="Cene" budget="200" />
        </div>
    );
  }
}

export default MonthlyBudget;
