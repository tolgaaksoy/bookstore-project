package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.dto.BookDto;
import com.tolgaaksoy.bookstoreApp.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getBooks();
    Book saveBook(BookDto bookDto);
    Optional<Book> findBookById(Long id);
    void deleteAuthorById(Long id);
    Long countOfBooks();
    List<Book> getByBookNameContaining(String bookName);
    List<Book> getByIsbnContaining(String isbn);
    List<Book> getByBookSeriesNameContaining(String bookSeriesName);
    List<Book> getByAuthorNameContaining(String authorName);
    List<Book> searchBook(String title, String keyword);



}
