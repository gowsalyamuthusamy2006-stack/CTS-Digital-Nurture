import React, { Component } from "react";

class CountPeople extends Component {
  constructor(props) {
    super(props);

    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((previousState) => ({
      entrycount: previousState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((previousState) => ({
      exitcount: previousState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ margin: "40px" }}>
        <h1>People Counter</h1>

        <button onClick={this.updateEntry}>
          Login
        </button>

        <span style={{ marginLeft: "10px" }}>
          {this.state.entrycount} People Entered
        </span>

        <br />
        <br />

        <button onClick={this.updateExit}>
          Exit
        </button>

        <span style={{ marginLeft: "10px" }}>
          {this.state.exitcount} People Left
        </span>
      </div>
    );
  }
}

export default CountPeople;