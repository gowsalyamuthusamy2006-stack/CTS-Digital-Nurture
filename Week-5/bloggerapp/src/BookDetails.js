function BookDetails() {
  const books = [
    { id: 101, name: "Master React", price: 670 },
    { id: 102, name: "Deep Dive into Angular 11", price: 800 },
    { id: 103, name: "Mongo Essentials", price: 450 }
  ];

  return (
    <div>
      <h2>Book Details</h2>

      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.name}</h3>
          <p>Price: ₹{book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;