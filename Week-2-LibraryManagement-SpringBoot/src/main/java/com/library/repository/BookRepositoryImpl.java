package com.library.repository;

import com.library.entity.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idGenerator.getAndIncrement());
            books.add(book);
        } else {
            deleteById(book.getId());
            books.add(book);
        }
        System.out.println("📚 Book saved: " + book.getTitle());
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByTitleContaining(String title) {
        return books.stream()
            .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
            .toList();
    }

    @Override
    public void deleteById(Long id) {
        books.removeIf(b -> b.getId().equals(id));
        System.out.println("🗑️ Book deleted: ID " + id);
    }

    @Override
    public boolean existsById(Long id) {
        return books.stream().anyMatch(b -> b.getId().equals(id));
    }
}