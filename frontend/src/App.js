import React from 'react';
import './index.css';

class Category extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      name: `Benzina`,
      budget: 200
    };
  }

  render() {
    return (
        <div
            className="category-container"
        >
          {this.state.name}
          {this.state.budget}
        </div>
    );
  }
}

export default Category;
