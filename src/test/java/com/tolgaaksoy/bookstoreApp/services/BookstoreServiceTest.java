package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;
import com.tolgaaksoy.bookstoreApp.repositories.BookstoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookstoreServiceTest {

    @Mock
    private BookstoreRepository bookstoreRepository;

    @InjectMocks
    private BookstoreService bookstoreService;

    @Test
    void getBookstories() {
        Mockito.when(bookstoreRepository.findAll()).thenReturn(Arrays.asList(
                new Bookstore("Can Yayınları", "Yayınevi", null),
                new Bookstore("İş Bankası Yayınları", "Banka Yayınevi", null),
                new Bookstore("Ithaki", "Kitapevi", null)
        ));

        List<Bookstore> allBookstories = bookstoreService.getBookstories();

        assertEquals("Can Yayınları" , allBookstories.get(0).getBookstoreName());
        assertEquals("Yayınevi", allBookstories.get(0).getDescription());

        assertEquals("İş Bankası Yayınları" , allBookstories.get(1).getBookstoreName());
        assertEquals("Banka Yayınevi", allBookstories.get(1).getDescription());

        assertEquals("Ithaki" , allBookstories.get(2).getBookstoreName());
        assertEquals("Kitapevi", allBookstories.get(2).getDescription());
    }

    @Test
    void save() {
        Bookstore bookstore = new Bookstore();
        Mockito.when(bookstoreRepository.save(bookstore)).
                thenReturn(new Bookstore("Can Yayınları", "Yayınevi", null));

        bookstore.setBookstoreName("Can Yayınları");
        bookstore.setDescription("Yayınevi");

        Bookstore savedBookstore = bookstoreService.saveBookstore(bookstore);

        assertThat(savedBookstore).isNotNull();

        assertEquals("Can Yayınları", savedBookstore.getBookstoreName());
        assertEquals("Yayınevi", savedBookstore.getDescription());
    }

    @Test
    void findById() {
        Mockito.when(bookstoreRepository.findById(1L)).
                thenReturn(Optional.of(new Bookstore("Can Yayınları", "Yayınevi", null)));

        Bookstore bookstore = bookstoreService.findBookstoreById(1L).get();

        assertEquals("Can Yayınları", bookstore.getBookstoreName());
        assertEquals("Yayınevi", bookstore.getDescription());
    }

    @Test
    void getByBookstoreNameContaining() {
        Mockito.when(bookstoreRepository.findByBookstoreNameContaining("Can"))
                .thenReturn(Arrays.asList(new Bookstore("Can Yayınları", "Yayınevi", null)));

        List<Bookstore> bookstores = bookstoreService.getByBookstoreNameContaining("Can");

        assertEquals("Can Yayınları", bookstores.get(0).getBookstoreName());
        assertEquals("Yayınevi", bookstores.get(0).getDescription());
    }
}