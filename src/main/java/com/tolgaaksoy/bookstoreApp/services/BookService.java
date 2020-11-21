package com.tolgaaksoy.bookstoreApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.dto.BookDto;
import com.tolgaaksoy.bookstoreApp.models.Author;
import com.tolgaaksoy.bookstoreApp.repositories.AuthorRepository;
import com.tolgaaksoy.bookstoreApp.repositories.BookstoreRepository;
import com.tolgaaksoy.bookstoreApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgaaksoy.bookstoreApp.models.Book;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookstoreRepository bookstoreRepository;

	@Override
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findBookById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book saveBook(BookDto bookDto) {
		Book book = null;
		if(bookDto.getId() != null ){
			book = bookRepository.findById(bookDto.getId()).get();
		}
		else{
			book = new Book();
		}
		book.setBookName(bookDto.getBookName());
		book.setBookSubName(bookDto.getBookSubName());
		book.setBookSeriesName(bookDto.getBookSeriesName());
		book.setIsbn(bookDto.getIsbn());
		book.setDescription(bookDto.getDescription());
		book.setAuthor(authorRepository.findById(bookDto.getAuthorid()).orElseThrow(() ->
				new IllegalArgumentException("Author : " + bookDto.getAuthorid() + "does not exist !")));
		book.setBookstore(bookstoreRepository.findById(bookDto.getBookstoreid()).orElseThrow(() ->
				new IllegalArgumentException("Bookstore : " + bookDto.getBookstoreid() + "does not exist !")));
		return bookRepository.save(book);
	}


	@Override
	public void deleteAuthorById(Long id) {
		Book book = bookRepository.findById(id).get();
		book.setAuthor(null);
		book.setBookstore(null);
		bookRepository.deleteById(id);
	}

	@Override
	public Long countOfBooks() {
		return bookRepository.count();
	}

	@Override
	public List<Book> searchBook(String title, String keyword) {
		switch (title){
			case "bookName":
				return getByBookNameContaining(keyword);
			case "seriesName":
				return getByBookSeriesNameContaining(keyword);
			case "isbn":
				return getByIsbnContaining(keyword);
			case "authorName":
				return getByAuthorNameContaining(keyword);
			default:
				return getBooks();
		}
	}

	@Override
	public List<Book> getByBookNameContaining(String bookName){
		return bookRepository.findByBookNameContaining(bookName);
	}

	@Override
	public List<Book> getByIsbnContaining(String isbn){
		return bookRepository.findByIsbnContaining(isbn);
	}

	@Override
	public List<Book> getByBookSeriesNameContaining(String bookSeriesName){
		return bookRepository.findByBookSeriesNameContaining(bookSeriesName);
	}

	@Override
	public List<Book> getByAuthorNameContaining(String authorName){
		List<Book> books = new ArrayList<>();
 		List<Author> authors = authorRepository.findByAuthorNameContaining(authorName);
		for (int i = 0; i < authors.size(); i++) {
			books.addAll(authors.get(i).getBooks());
		}
		return books;
	}
}
