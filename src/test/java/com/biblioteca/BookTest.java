package com.biblioteca;

import com.biblioteca.model.Author;
import com.biblioteca.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookProperties() {
        Author author = new Author("Isaac", "Asimov", "Sci-Fi writer");
        Book book = new Book("ISBN201", "Fundación", 1951, author);

        assertEquals("ISBN201", book.getIsbn());
        assertEquals("Fundación", book.getTitle());
        assertEquals(1951, book.getPublicationYear());
        assertEquals(author, book.getAuthor());

        book.setTitle("Nueva Fundación");
        assertEquals("Nueva Fundación", book.getTitle());

        book.setPublicationYear(1952);
        assertEquals(1952, book.getPublicationYear());
    }
}
