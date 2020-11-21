package com.tolgaaksoy.bookstoreApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tolgaaksoy.bookstoreApp.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookNameContaining(String bookName);
    List<Book> findByIsbnContaining(String isbn);
    List<Book> findByBookSeriesNameContaining(String bookSeriesName);
    List<Book> findAllById(Long id);
}
