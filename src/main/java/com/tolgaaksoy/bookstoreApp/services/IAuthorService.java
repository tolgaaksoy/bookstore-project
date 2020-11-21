package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.models.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> getAuthors();
    Author saveAuthor(Author author);
    Optional<Author> findAuthorById(Long id);
    void deleteAuthorById(Long id);
    List<Author> getByAuthorNameContaining(String authorName);
    Long countOfAuthors();
}
