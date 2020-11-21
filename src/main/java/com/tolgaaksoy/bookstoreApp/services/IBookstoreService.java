package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;

import java.util.List;
import java.util.Optional;

public interface IBookstoreService {
    List<Bookstore> getBookstories();
    Bookstore saveBookstore(Bookstore bookstore);
    Optional<Bookstore> findBookstoreById(Long id);
    void deleteBookstoreById(Long id);
    Long countOfBookstore();
    List<Bookstore> getByBookstoreNameContaining(String bookstoreName);
}
