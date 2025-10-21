package com.biblioteca.factory;
import com.biblioteca.model.Book;
import com.biblioteca.model.Author;

public class BookFactory {
    public static Book createBook(String isbn, String title, int year, Author author) {
        return new Book(isbn, title, year, author);
    }
}
