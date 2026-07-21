import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  validateForm = () => {
    const errors = {};

    if (this.state.name.trim().length < 5) {
      errors.name = "Name should contain at least 5 characters";
    }

    if (
      !this.state.email.includes("@") ||
      !this.state.email.includes(".")
    ) {
      errors.email = "Enter a valid email address";
    }

    if (this.state.password.length < 8) {
      errors.password = "Password should contain at least 8 characters";
    }

    return errors;
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const errors = this.validateForm();

    if (Object.keys(errors).length > 0) {
      this.setState({ errors });
      return;
    }

    alert("Registration Successful");

    this.setState({
      name: "",
      email: "",
      password: "",
      errors: {}
    });
  };

  render() {
    const { name, email, password, errors } = this.state;

    return (
      <div style={{ margin: "40px" }}>
        <h1>Mail Registration</h1>

        <form onSubmit={this.handleSubmit}>
          <label>Name</label>
          <br />

          <input
            type="text"
            name="name"
            value={name}
            onChange={this.handleChange}
          />

          {errors.name && (
            <p style={{ color: "red" }}>{errors.name}</p>
          )}

          <br />

          <label>Email</label>
          <br />

          <input
            type="text"
            name="email"
            value={email}
            onChange={this.handleChange}
          />

          {errors.email && (
            <p style={{ color: "red" }}>{errors.email}</p>
          )}

          <br />

          <label>Password</label>
          <br />

          <input
            type="password"
            name="password"
            value={password}
            onChange={this.handleChange}
          />

          {errors.password && (
            <p style={{ color: "red" }}>{errors.password}</p>
          )}

          <br />

          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Register;