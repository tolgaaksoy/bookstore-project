package com.tolgaaksoy.bookstoreApp.services;

import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.models.Book;
import com.tolgaaksoy.bookstoreApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;
import com.tolgaaksoy.bookstoreApp.repositories.BookstoreRepository;

@Service
public class BookstoreService implements IBookstoreService{
	
	@Autowired
	private BookstoreRepository bookstoreRepository;
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Bookstore> getBookstories(){
		return bookstoreRepository.findAll();
	}

	@Override
	public Optional<Bookstore> findBookstoreById(Long id) {
		return bookstoreRepository.findById(id);
	}

	@Override
	public Bookstore saveBookstore(Bookstore bookstore) {
		Bookstore savedBookstore = bookstoreRepository.save(bookstore);
		return savedBookstore;
	}

	@Override
	public void deleteBookstoreById(Long id) {
		bookstoreRepository.deleteById(id);
	}

	@Override
	public Long countOfBookstore() {
		return bookstoreRepository.count();
	}

	@Override
	public List<Bookstore> getByBookstoreNameContaining(String bookstoreName){
		return bookstoreRepository.findByBookstoreNameContaining(bookstoreName);
	}
}

//	public void updateBookstore(Bookstore bookstore){
//		List<Book> books = bookRepository.findAllById(bookstore.getId());
//		for (int i = 0; i < books.size(); i++) {
//			books.get(i).setBookstore(bookstore);
//			bookRepository.save(books.get(i));
//		}
//		bookstoreRepository.save(bookstore);
//	}
