package com.tolgaaksoy.bookstoreApp.repositories;

import com.tolgaaksoy.bookstoreApp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByAuthorNameContaining(String authorName);
    Optional<Author> findById(Long id);
}
