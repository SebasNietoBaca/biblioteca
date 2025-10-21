package com.biblioteca;

import com.biblioteca.model.Book;
import com.biblioteca.model.User;
import com.biblioteca.model.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testBorrowAndReturnBook() {
        Author author = new Author("Gabriel", "García Márquez", "Colombian writer");
        Book book = new Book("ISBN300", "Cien Años de Soledad", 1967, author);
        User user = new User("juan@example.com", "Juan", "1234");

        user.borrowBook(book);
        assertTrue(user.getBorrowedBooks().contains(book), "Usuario debe tener el libro");

        user.returnBook(book);
        assertFalse(user.getBorrowedBooks().contains(book), "Usuario no debe tener el libro");
    }
}
