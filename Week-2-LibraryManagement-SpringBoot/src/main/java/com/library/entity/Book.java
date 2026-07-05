package com.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private LocalDate addedDate;
    private Boolean available = true;

    public Book() {
        this.addedDate = LocalDate.now();
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.addedDate = LocalDate.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Integer getPublicationYear() { return publicationYear; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }
    public LocalDate getAddedDate() { return addedDate; }
    public void setAddedDate(LocalDate addedDate) { this.addedDate = addedDate; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}