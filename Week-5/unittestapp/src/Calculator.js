function Calculator({ a, b }) {
  return (
    <div>
      <h1>Calculator</h1>
      <p>Sum: {a + b}</p>
      <p>Difference: {a - b}</p>
      <p>Product: {a * b}</p>
    </div>
  );
}

export default Calculator;