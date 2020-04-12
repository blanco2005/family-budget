import React, {Component, useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [message, setMessage] = useState("");

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
          <button
              className="category-container"
          >
            {this.state.name}
            {this.state.budget}
          </button>
      );
    }
  }

//   useEffect(() => {
//     fetch('/monthlybudget/current')
//     .then(response => response.text())
//     .then(message => {
//       setMessage(message);
//     });
//   },[])
//
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//           {message}
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
}

export default App;
