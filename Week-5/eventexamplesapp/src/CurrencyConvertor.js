import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      rupees: "",
      euro: ""
    };
  }

  handleChange = (event) => {
    this.setState({
      rupees: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const rupeesValue = Number(this.state.rupees);

    if (this.state.rupees === "" || Number.isNaN(rupeesValue)) {
      alert("Please enter a valid rupee amount");
      return;
    }

    const euroValue = rupeesValue / 90;

    this.setState({
      euro: euroValue.toFixed(2)
    });
  };

  render() {
    return (
      <div>
        <h2>Currency Converter</h2>

        <form onSubmit={this.handleSubmit}>
          <label>
            Enter amount in Rupees:
            <input
              type="number"
              value={this.state.rupees}
              onChange={this.handleChange}
              style={{ marginLeft: "10px" }}
            />
          </label>

          <button type="submit" style={{ marginLeft: "10px" }}>
            Convert
          </button>
        </form>

        {this.state.euro && (
          <h3>Euro: €{this.state.euro}</h3>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;