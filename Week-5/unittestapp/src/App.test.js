import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders calculator app", () => {
  render(<App />);

  expect(
    screen.getByRole("heading", { name: "Calculator" })
  ).toBeInTheDocument();
});