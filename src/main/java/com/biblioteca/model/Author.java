package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public Author() {}

    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    // -------- Getters y Setters --------
    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBiography() { return biography; }

    public void setBiography(String biography) { this.biography = biography; }

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) { this.books = books; }

    // -------- Métodos agregados --------
    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
