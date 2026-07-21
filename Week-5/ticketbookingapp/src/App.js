import React, { Component } from "react";

function GuestGreeting() {
  return <h2>Please sign up.</h2>;
}

function UserGreeting() {
  return <h2>Welcome back</h2>;
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const isLoggedIn = this.state.isLoggedIn;

    return (
      <div style={{ margin: "40px" }}>
        <Greeting isLoggedIn={isLoggedIn} />

        {isLoggedIn ? (
          <LogoutButton onClick={this.handleLogout} />
        ) : (
          <LoginButton onClick={this.handleLogin} />
        )}
      </div>
    );
  }
}

export default App;