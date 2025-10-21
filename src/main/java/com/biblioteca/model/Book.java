package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String title;
    private int publicationYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private User borrower;

    public Book() {}

    public Book(String isbn, String title, int publicationYear, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public Book(String title, String isbn, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public Long getId() { return id; }

    public String getIsbn() { return isbn; }

    public String getTitle() { return title; }

    public int getPublicationYear() { return publicationYear; }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) { this.author = author; }

    public User getBorrower() { return borrower; }

    public void setBorrower(User borrower) { this.borrower = borrower; }

    public void setTitle(String title) { this.title = title; }

    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    @Override
    public String toString() {
        return title + " (" + isbn + ")";
    }
}
