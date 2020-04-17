import React from 'react';
import "../index.css"

class Category extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
        <div className="Category">
          <p>{this.props.name}</p>
          <p>{this.props.budget}</p>
        </div>
    );
  }
}

export default Category