package com.tolgaaksoy.bookstoreApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;

import java.util.List;
import java.util.Optional;

@Repository

public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {
    List<Bookstore> findByBookstoreNameContaining(String bookstoreName);
    Optional<Bookstore> findById(Long id);

}
