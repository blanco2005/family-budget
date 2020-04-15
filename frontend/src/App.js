import React from 'react';
import './index.css';
import Category from "./Category/Category";
import Header from "./Header/Header";

class MonthlyBudget extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      month: `April`,
      year: `2020`,
      categories: [
        {name: 'Benzina', budget:'120'},
        {name: 'Cene', budget:'200'},
        {name: 'Casa', budget: '500'}
      ]
    }
  }

  render() {
    return (
        <div>
          <Header />
          <div className="monthly-budget">
            <h1 style={{marginTop:50}}>Budget of {this.state.month} {this.state.year}</h1>
            {
              this.props.categories.map((category, index) =>
                <Category name={category.name} budget={category.money} key={index}/>
              )
            }
          </div>
        </div>
    );
  }
}

export default MonthlyBudget;
