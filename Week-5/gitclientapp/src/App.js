import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      repositories: [],
      loading: true,
      error: ""
    };
  }

  componentDidMount() {
    GitClient.getRepositories("techiesyed")
      .then((repositoryNames) => {
        this.setState({
          repositories: repositoryNames,
          loading: false
        });
      })
      .catch(() => {
        this.setState({
          error: "Unable to load repositories",
          loading: false
        });
      });
  }

  render() {
    return (
      <div style={{ margin: "30px" }}>
        <h1>GitHub Repositories</h1>

        {this.state.loading && <p>Loading...</p>}

        {this.state.error && <p>{this.state.error}</p>}

        <ul>
          {this.state.repositories.map((repository) => (
            <li key={repository}>{repository}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;