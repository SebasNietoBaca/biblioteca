package com.biblioteca.factory;
import com.biblioteca.model.Author;

public class AuthorFactory {
    public static Author createAuthor(String firstName, String lastName, String bio) {
        return new Author(firstName, lastName, bio);
    }
}
