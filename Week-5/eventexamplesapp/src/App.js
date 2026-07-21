import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState(
      (previousState) => ({
        counter: previousState.counter + 1
      }),
      this.sayHello
    );
  };

  decrement = () => {
    this.setState((previousState) => ({
      counter: previousState.counter - 1
    }));
  };

  sayHello = () => {
    alert("Hello! The counter was increased.");
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleSyntheticEvent = (event) => {
    alert("I was clicked");
    console.log(event);
  };

  render() {
    return (
      <div style={{ margin: "30px" }}>
        <h1>Event Examples App</h1>

        <h2>Counter: {this.state.counter}</h2>

        <button onClick={this.increment}>
          Increment
        </button>

        <button
          onClick={this.decrement}
          style={{ marginLeft: "10px" }}
        >
          Decrement
        </button>

        <br />
        <br />

        <button onClick={() => this.sayWelcome("Welcome")}>
          Say Welcome
        </button>

        <br />
        <br />

        <button onClick={this.handleSyntheticEvent}>
          OnPress
        </button>

        <hr />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;