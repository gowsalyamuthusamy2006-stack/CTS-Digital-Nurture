import { render, screen } from "@testing-library/react";
import Calculator from "./Calculator";

test("renders calculator heading", () => {
  render(<Calculator a={20} b={10} />);
  expect(screen.getByText("Calculator")).toBeInTheDocument();
});

test("checks sum", () => {
  render(<Calculator a={20} b={10} />);
  expect(screen.getByText("Sum: 30")).toBeInTheDocument();
});

test("checks difference", () => {
  render(<Calculator a={20} b={10} />);
  expect(screen.getByText("Difference: 10")).toBeInTheDocument();
});

test("checks product", () => {
  render(<Calculator a={20} b={10} />);
  expect(screen.getByText("Product: 200")).toBeInTheDocument();
});