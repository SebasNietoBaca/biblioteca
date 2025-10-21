package com.biblioteca;

import com.biblioteca.model.Author;
import com.biblioteca.model.Book;
import com.biblioteca.service.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();

        Author author1 = new Author("Gabriel", "García Márquez", "Escritor colombiano, Nobel de Literatura.");
        Author author2 = new Author("Isabel", "Allende", "Escritora chilena, autora de 'La casa de los espíritus'.");

        Book book1 = new Book("Cien Años de Soledad", "ISBN999", 1967);
        Book book2 = new Book("El amor en los tiempos del cólera", "ISBN1000", 1985);
        Book book3 = new Book("La casa de los espíritus", "ISBN1001", 1982);

        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book3);

        library.addAuthor(author1);
        library.addAuthor(author2);
    }

    @Test
    public void testFindAllAuthors() {
        assertEquals(2, library.getAllAuthors().size());
    }

    @Test
    public void testFindBooksByAuthor() {
        Author gabriel = library.findAuthorByLastName("García Márquez");
        Set<Book> books = gabriel.getBooks(); // ✅ corregido
        assertEquals(2, books.size());
    }

    @Test
    public void testAddBook() {
        Author isabel = library.findAuthorByLastName("Allende");
        Book newBook = new Book("Paula", "ISBN1002", 1994);
        isabel.addBook(newBook);
        library.updateAuthor(isabel);

        Author updatedIsabel = library.findAuthorByLastName("Allende");
        assertEquals(2, updatedIsabel.getBooks().size());
    }
}
