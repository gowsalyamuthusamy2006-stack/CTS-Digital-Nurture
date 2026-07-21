import React, { useEffect, useState } from "react";
import { getEmployees } from "./EmployeeService";

function EmployeeList() {

    const [employees, setEmployees] = useState([]);

    useEffect(() => {

        getEmployees()
            .then((response) => {
                setEmployees(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

    }, []);

    return (

        <div style={{ margin: "30px" }}>

            <h1>Employee List</h1>

            <table border="1" cellPadding="10">

                <thead>

                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Company</th>
                    </tr>

                </thead>

                <tbody>

                    {
                        employees.map((employee) => (

                            <tr key={employee.id}>

                                <td>{employee.id}</td>
                                <td>{employee.name}</td>
                                <td>{employee.email}</td>
                                <td>{employee.company.name}</td>

                            </tr>

                        ))
                    }

                </tbody>

            </table>

        </div>

    );
}

export default EmployeeList;