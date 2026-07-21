import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employeeName: "",
            complaint: ""
        };
    }

    handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    handleSubmit = (event) => {
        event.preventDefault();

        const referenceNumber =
            "REF" + Math.floor(Math.random() * 100000);

        alert(
            "Complaint Registered Successfully!\nReference Number: " +
            referenceNumber
        );

        this.setState({
            employeeName: "",
            complaint: ""
        });
    };

    render() {
        return (
            <div style={{ margin: "40px" }}>
                <h1>Ticket Raising App</h1>

                <form onSubmit={this.handleSubmit}>

                    <label>Employee Name</label>
                    <br />

                    <input
                        type="text"
                        name="employeeName"
                        value={this.state.employeeName}
                        onChange={this.handleChange}
                    />

                    <br /><br />

                    <label>Complaint</label>
                    <br />

                    <textarea
                        name="complaint"
                        rows="5"
                        cols="40"
                        value={this.state.complaint}
                        onChange={this.handleChange}
                    />

                    <br /><br />

                    <button type="submit">
                        Submit
                    </button>

                </form>
            </div>
        );
    }
}

export default ComplaintRegister;