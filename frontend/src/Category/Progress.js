import 'bootstrap/dist/css/bootstrap.min.css';
import ProgressBar from 'react-bootstrap/ProgressBar'
import React from "react";

class Progress extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
        <div style={{padding: "30px"}}>
          <ProgressBar variant="success" now={10}/>
          <p style={{textAlign: "left", float: "left", overflow: "auto"}}>0.00€</p>
          <p style={{textAlign: "right", float: "right", overflow: "auto"}}>{this.props.budget}€</p>
        </div>
    )
  }
}

export default Progress;