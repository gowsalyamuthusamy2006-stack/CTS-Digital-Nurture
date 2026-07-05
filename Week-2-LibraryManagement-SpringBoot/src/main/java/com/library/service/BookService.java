package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        System.out.println("🔧 BookService: Constructor Injection");
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        System.out.println("📖 Adding book: " + book.getTitle());
        return bookRepository.save(book);
    }

    public Book addBook(String title, String author) {
        Book book = new Book(title, author);
        return addBook(book);
    }

    public List<Book> getAllBooks() {
        System.out.println("📚 Getting all books");
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        System.out.println("🔍 Getting book by ID: " + id);
        return bookRepository.findById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        System.out.println("🔎 Searching books by title: " + title);
        return bookRepository.findByTitleContaining(title);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with ID: " + id);
        }
        System.out.println("🗑️ Deleting book with ID: " + id);
        bookRepository.deleteById(id);
    }
}