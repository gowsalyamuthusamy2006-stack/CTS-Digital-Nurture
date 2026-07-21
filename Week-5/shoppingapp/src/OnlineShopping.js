import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

  constructor() {
    super();

    this.items = [
      new Cart("Laptop", 65000),
      new Cart("Mobile", 25000),
      new Cart("Headphones", 3000),
      new Cart("Keyboard", 1500),
      new Cart("Mouse", 800)
    ];
  }

  render() {
    return (
      <div style={{ margin: "30px" }}>
        <h1>Online Shopping Cart</h1>

        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price (₹)</th>
            </tr>
          </thead>

          <tbody>
            {this.items.map((item, index) => (
              <tr key={index}>
                <td>{item.itemName}</td>
                <td>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;