import React from 'react';
import "../index.css"
import Progress from "./Progress";

class Category extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {

    // TODO assign variant based on remaining value variant=success, info, warning, danger

    return (
        <div className="Category">
          <p style={{textAlign:"left", paddingLeft:"20px"}}>{this.props.name}</p>
          <Progress budget={this.props.budget}/>
        </div>
    );
  }
}

export default Category