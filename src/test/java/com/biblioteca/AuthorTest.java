package com.biblioteca;

import com.biblioteca.model.Author;
import com.biblioteca.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    @Test
    public void testAddAndRemoveBook() {
        Author author = new Author("Gabriel", "García Márquez", "Colombian writer");
        Book book = new Book("ISBN200", "Cien Años de Soledad", 1967, author);

        author.addBook(book);
        assertTrue(author.getBooks().contains(book), "Author debe tener el libro agregado");
        assertEquals(author, book.getAuthor(), "El libro debe tener el autor asignado");

        author.removeBook(book);
        assertFalse(author.getBooks().contains(book), "Author no debe tener el libro");
        assertNull(book.getAuthor(), "El libro ya no debe tener autor");
    }
}
