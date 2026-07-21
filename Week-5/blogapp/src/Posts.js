import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

    constructor(props) {
        super(props);

        this.state = {
            posts: [],
            error: null
        };
    }

    loadPosts = async () => {
        try {

            const response = await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

            const data = await response.json();

            const postList = data.map(
                p => new Post(p.id, p.title, p.body)
            );

            this.setState({
                posts: postList
            });

        } catch (error) {

            this.setState({
                error
            });

        }
    };

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error) {

        alert(error);

    }

    render() {

        if (this.state.error) {
            return <h2>Error Loading Posts</h2>;
        }

        return (

            <div style={{ margin: "20px" }}>

                <h1>Blog Posts</h1>

                {
                    this.state.posts.map(post => (

                        <div
                            key={post.id}
                            style={{
                                border: "1px solid gray",
                                marginBottom: "20px",
                                padding: "10px"
                            }}
                        >

                            <h3>{post.title}</h3>

                            <p>{post.body}</p>

                        </div>

                    ))
                }

            </div>

        );
    }
}

export default Posts;