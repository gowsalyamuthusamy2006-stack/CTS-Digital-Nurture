import EmployeeCard from "./EmployeeCard";

function EmployeeList() {
  const employees = [
    {
      id: 1,
      name: "Sachin",
      department: "Training",
      designation: "React Trainer"
    },
    {
      id: 2,
      name: "Rahul",
      department: "Development",
      designation: "Java Developer"
    },
    {
      id: 3,
      name: "Amit",
      department: "Testing",
      designation: "QA Engineer"
    }
  ];

  return (
    <div>
      <h1>Employee List</h1>

      {employees.map((employee) => (
        <EmployeeCard
          key={employee.id}
          employee={employee}
        />
      ))}
    </div>
  );
}

export default EmployeeList;