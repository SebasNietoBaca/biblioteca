package com.biblioteca.main;

import com.biblioteca.model.Author;
import com.biblioteca.model.Book;
import com.biblioteca.model.User;
import com.biblioteca.service.Library;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager em = emf.createEntityManager();
        Library library = new Library(em);

        try {
            Author author = new Author("Gabriel", "García Márquez", "Escritor colombiano");
            library.addAuthor(author);

            Book book = new Book("ISBN001", "Cien Años de Soledad", 1967, author);
            library.addBook(book);

            User user = new User("juan@example.com", "Juan Pérez", "12345");
            library.addUser(user);

            library.borrowBook(user, book);
            library.returnBook(user, book);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            library.close();
            emf.close();
        }
    }
}
