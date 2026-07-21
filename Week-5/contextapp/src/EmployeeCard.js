import { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const buttonStyle = {
    backgroundColor: theme === "dark" ? "black" : "white",
    color: theme === "dark" ? "white" : "black",
    border: "1px solid black",
    padding: "8px 15px",
    cursor: "pointer"
  };

  return (
    <div
      style={{
        border: "1px solid gray",
        padding: "15px",
        marginBottom: "15px",
        width: "300px"
      }}
    >
      <h2>{employee.name}</h2>
      <p>Department: {employee.department}</p>
      <p>Designation: {employee.designation}</p>

      <button style={buttonStyle}>View Details</button>
    </div>
  );
}

export default EmployeeCard;