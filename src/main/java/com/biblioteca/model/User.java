package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fullName;
    private String password;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    private Set<Book> borrowedBooks = new HashSet<>();

    public User() {}

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public Long getId() { return id; }

    public String getEmail() { return email; }

    public String getFullName() { return fullName; }

    public String getPassword() { return password; }

    public Set<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrower(this);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setBorrower(null);
    }

    @Override
    public String toString() {
        return fullName + " (" + email + ")";
    }
}
