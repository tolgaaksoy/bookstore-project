package com.tolgaaksoy.bookstoreApp.services;

import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgaaksoy.bookstoreApp.repositories.AuthorRepository;

@Service
public class AuthorService implements IAuthorService{

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}

	@Override
	public Author saveAuthor(Author author) {
		Author savedAuthor = authorRepository.save(author);
		return savedAuthor;
	}

	@Override
	public Optional<Author> findAuthorById(Long id) {
		return  authorRepository.findById(id);
	}

	@Override
	public void deleteAuthorById(Long id) {
		authorRepository.deleteById(id);
	}

	@Override
	public List<Author> getByAuthorNameContaining(String authorName) {
		return authorRepository.findByAuthorNameContaining(authorName);
	}

	@Override
	public Long countOfAuthors() {
		return authorRepository.count();
	}
}
