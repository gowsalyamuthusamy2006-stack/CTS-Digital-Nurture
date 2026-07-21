function BlogDetails() {
  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Sachin",
      description: "Welcome to learning React."
    },
    {
      id: 2,
      title: "Installation",
      author: "Amit",
      description: "You can install React from npm."
    }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      {blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.description}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;