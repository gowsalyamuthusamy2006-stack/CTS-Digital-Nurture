import axios from "axios";

class GitClient {
  static getRepositories(username) {
    return axios
      .get(`https://api.github.com/users/${username}/repos`)
      .then((response) => {
        return response.data.map((repository) => repository.name);
      });
  }
}

export default GitClient;