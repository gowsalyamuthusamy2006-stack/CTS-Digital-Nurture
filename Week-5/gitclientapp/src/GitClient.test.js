import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", async () => {
    const mockData = [
      { id: 1, name: "react-project" },
      { id: 2, name: "spring-boot-project" },
      { id: 3, name: "portfolio" }
    ];

    axios.get.mockResolvedValue({
      data: mockData
    });

    const repositoryNames =
      await GitClient.getRepositories("techiesyed");

    expect(axios.get).toHaveBeenCalledWith(
      "https://api.github.com/users/techiesyed/repos"
    );

    expect(repositoryNames).toEqual([
      "react-project",
      "spring-boot-project",
      "portfolio"
    ]);
  });
});