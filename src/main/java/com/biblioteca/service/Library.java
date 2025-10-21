package com.biblioteca.service;

import com.biblioteca.model.Author;
import com.biblioteca.model.Book;
import com.biblioteca.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class Library {

    private final EntityManager em;

    public Library(EntityManager em) {
        this.em = em;
    }

    public Library() {
        this.em = jakarta.persistence.Persistence
                .createEntityManagerFactory("bibliotecaPU")
                .createEntityManager();
    }

    public void close() {
        if (em.isOpen()) em.close();
    }

    // ------------------ Métodos CRUD ------------------

    public void addAuthor(Author author) {
        executeTransaction(() -> em.persist(author));
    }

    public void addBook(Book book) {
        executeTransaction(() -> em.persist(book));
    }

    public void addUser(User user) {
        executeTransaction(() -> em.persist(user));
    }

    public void updateAuthor(Author author) {
        executeTransaction(() -> em.merge(author));
    }

    public void deleteAuthor(Author author) {
        executeTransaction(() -> {
            Author a = em.merge(author);
            em.remove(a);
        });
    }

    public void deleteBook(Book book) {
        executeTransaction(() -> {
            Book b = em.merge(book);
            em.remove(b);
        });
    }

    public void deleteUser(User user) {
        executeTransaction(() -> {
            User u = em.merge(user);
            em.remove(u);
        });
    }

    // ------------------ Consultas ------------------

    public List<Author> getAllAuthors() {
        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }

    public Author findAuthorByLastName(String lastName) {
        TypedQuery<Author> query = em.createQuery(
                "SELECT a FROM Author a WHERE a.lastName = :lastName", Author.class);
        query.setParameter("lastName", lastName);
        List<Author> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // ------------------ Lógica de préstamos ------------------

    public void borrowBook(User user, Book book) {
        executeTransaction(() -> {
            Book b = em.merge(book);
            User u = em.merge(user);
            b.setBorrower(u);
            u.getBorrowedBooks().add(b);
        });
        System.out.println(user.getFullName() + " tomó prestado el libro " + book.getTitle());
    }

    public void returnBook(User user, Book book) {
        executeTransaction(() -> {
            Book b = em.merge(book);
            User u = em.merge(user);
            b.setBorrower(null);
            u.getBorrowedBooks().remove(b);
        });
        System.out.println(user.getFullName() + " devolvió el libro " + book.getTitle());
    }

    // ------------------ Transacción Helper ------------------

    private void executeTransaction(Runnable action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.run();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}
