import React, { Component } from "react";
import EmployeeList from "./EmployeeList";
import ThemeContext from "./ThemeContext";

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      theme: "light"
    };
  }

  toggleTheme = () => {
    this.setState((previousState) => ({
      theme: previousState.theme === "light" ? "dark" : "light"
    }));
  };

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div style={{ margin: "30px" }}>
          <button onClick={this.toggleTheme}>
            Change Theme
          </button>

          <p>Current Theme: {this.state.theme}</p>

          <EmployeeList />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;