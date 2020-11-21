package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.models.Book;
import com.tolgaaksoy.bookstoreApp.repositories.BookRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void getBooks() {
        Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(
                new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap", null, null),
                new Book("Dönüşüm","Hikaye"," - ", "789-456", "Hikaye", null, null)
        ));

        List<Book> books = bookService.getBooks();

        assertEquals("Outliers", books.get(0).getBookName());
        assertEquals("Kişisel Gelişim", books.get(0).getBookSubName());
        assertEquals(" - ", books.get(0).getBookSeriesName());
        assertEquals("123-456", books.get(0).getIsbn());
        assertEquals("Kitap", books.get(0).getDescription());

        assertEquals("Dönüşüm", books.get(1).getBookName());
        assertEquals("Hikaye", books.get(1).getBookSubName());
        assertEquals(" - ", books.get(1).getBookSeriesName());
        assertEquals("789-456", books.get(1).getIsbn());
        assertEquals("Hikaye", books.get(1).getDescription());

    }

    @Test
    void save() {
//        Book book = new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap",
//                null,null);
//        BookDto bookDto = new BookDto();
//
//        Mockito.when(bookRepository.save(book)).
//                thenReturn(new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap",
//                        null,null));
//
//        bookDto.setAuthorid(null);
//        bookDto.setBookName("Outliers");
//        bookDto.setBookSubName("Kişisel Gelişim");
//        bookDto.setBookSeriesName(" - ");
//        bookDto.setIsbn("123-456");
//        bookDto.setAuthorid(1L);
//        bookDto.setBookstoreid(1L);
//
//        Book savedBook = bookService.save(bookDto);
//
//        assertEquals("Outliers", savedBook.getBookName());
//        assertEquals("Kişisel Gelişim", savedBook.getBookSubName());
//        assertEquals(" - ", savedBook.getBookSeriesName());
//        assertEquals("123-456", savedBook.getIsbn());
////        assertEquals("Can Yücel", savedBook.getAuthor().getAuthorName());
////        assertEquals("Can Yayınları", savedBook.getBookstore().getBookstoreName());
//
//        Author author = new Author("Can Yücel", "Yazar", null);
//        Bookstore bookstore = new Bookstore("Can Yayınları", "Yayınevi", null);
//
//        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(new Author("Can Yücel", "Yazar", null)));
//
//        Mockito.when(bookstoreRepository.findById(1L)).
//                thenReturn(Optional.of(new Bookstore("Can Yayınları", "Yayınevi", null)));
    }

    @Test
    void findById() {
        Mockito.when(bookRepository.findById(1L)).
                thenReturn(Optional.of(new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap",
                        null,null)));

        Book book = bookService.findBookById(1L).get();

        assertEquals("Outliers", book.getBookName());
        assertEquals("Kişisel Gelişim", book.getBookSubName());
        assertEquals(" - ", book.getBookSeriesName());
        assertEquals("123-456", book.getIsbn());
        assertEquals("Kitap", book.getDescription());
//        assertEquals("Can Yücel", book.getAuthor().getAuthorName());
//        assertEquals("Can Yayınları", book.getBookstore().getBookstoreName());

    }

    @Test
    void getByBookNameContaining() {
        Mockito.when(bookRepository.findByBookNameContaining("Out")).
                thenReturn(Arrays.asList(new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap",
                        null,null)));

        List<Book> books = bookService.getByBookNameContaining("Out");

        assertEquals("Outliers", books.get(0).getBookName());
        assertEquals("Kişisel Gelişim", books.get(0).getBookSubName());
        assertEquals(" - ", books.get(0).getBookSeriesName());
        assertEquals("123-456", books.get(0).getIsbn());
        assertEquals("Kitap", books.get(0).getDescription());
    }

    @Test
    void getByIsbnContaining() {
        Mockito.when(bookRepository.findByIsbnContaining("123")).
                thenReturn(Arrays.asList(new Book("Outliers","Kişisel Gelişim"," - ", "123-456", "Kitap",
                        null,null)));

        List<Book> books = bookService.getByIsbnContaining("123");

        assertEquals("Outliers", books.get(0).getBookName());
        assertEquals("Kişisel Gelişim", books.get(0).getBookSubName());
        assertEquals(" - ", books.get(0).getBookSeriesName());
        assertEquals("123-456", books.get(0).getIsbn());
        assertEquals("Kitap", books.get(0).getDescription());

    }

    @Test
    void getByBookSeriesNameContaining() {
        Mockito.when(bookRepository.findByBookSeriesNameContaining("Geliş")).
                thenReturn(Arrays.asList(new Book("Outliers","Kişisel Gelişim","Gelişim", "123-456", "Kitap",
                        null,null)));

        List<Book> books = bookService.getByBookSeriesNameContaining("Geliş");

        assertEquals("Outliers", books.get(0).getBookName());
        assertEquals("Kişisel Gelişim", books.get(0).getBookSubName());
        assertEquals("Gelişim", books.get(0).getBookSeriesName());
        assertEquals("123-456", books.get(0).getIsbn());
        assertEquals("Kitap", books.get(0).getDescription());

    }

    @Test
    void getByAuthorNameContaining() {
//        Mockito.when(authorRepository.findByAuthorNameContaining("Can")).thenReturn(Arrays.asList(
//                new Author("Can Yücel", "Yazar", null)
//        ));
//
//        Mockito.when(bookRepository.findByBookSeriesNameContaining("Can")).
//                thenReturn(Arrays.asList(new Book("Outliers","Kişisel Gelişim","Gelişim", "123-456", "Kitap",
//                        new Author("Can Yücel", "Yazar", null),
//                        new Bookstore("Can Yayınları", "Yayınevi", null))));
//
//        List<Book> books = bookService.getByAuthorNameContaining("Can");
//
//        assertEquals("Outliers", books.get(0).getBookName());
//        assertEquals("Kişisel Gelişim", books.get(0).getBookSubName());
//        assertEquals("Gelişim", books.get(0).getBookSeriesName());
//        assertEquals("123-456", books.get(0).getIsbn());
//        assertEquals("Kitap", books.get(0).getDescription());
//        assertEquals("Can Yücel", books.get(0).getAuthor().getAuthorName());
//        assertEquals("Can Yayınları", books.get(0).getBookstore().getBookstoreName());
    }

//    @Test
//    void search() {
//
//    }
}