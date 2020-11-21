package com.tolgaaksoy.bookstoreApp.services;

import com.tolgaaksoy.bookstoreApp.models.Author;
import com.tolgaaksoy.bookstoreApp.repositories.AuthorRepository;
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
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorService authorService;

    @Test
    void shouldSavedAuthorSuccessFully() {
        Author author = new Author();

        Mockito.when(authorRepository.save(author)).thenReturn(new Author("Can Yücel", "Yazar", null));

        author.setAuthorName("Can Yücel");
        author.setDescription("Yazar");

        Author savedAuthor = authorService.saveAuthor(author);

        assertThat(savedAuthor).isNotNull();

        assertEquals("Can Yücel", savedAuthor.getAuthorName());
        assertEquals("Yazar", savedAuthor.getDescription());
    }

    @Test
    void findAuthor() {
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(new Author("Can Yücel", "Yazar", null)));

        Author author = authorService.findAuthorById(1L).get();

        assertEquals("Can Yücel", author.getAuthorName());
        assertEquals("Yazar", author.getDescription());

    }

    @Test
    void findAllAuthor() {
        Mockito.when(authorRepository.findAll()).thenReturn(Arrays.asList(
                new Author("Can Yücel", "Yazar", null),
                new Author("İsmet Özel", "Sair", null),
                new Author("Jack London", "Hikayeci", null)
        ));

        List<Author> allAuthor = authorService.getAuthors();

        assertEquals("Can Yücel", allAuthor.get(0).getAuthorName());
        assertEquals("Yazar", allAuthor.get(0).getDescription());

        assertEquals("İsmet Özel", allAuthor.get(1).getAuthorName());
        assertEquals("Sair", allAuthor.get(1).getDescription());

        assertEquals("Jack London", allAuthor.get(2).getAuthorName());
        assertEquals("Hikayeci", allAuthor.get(2).getDescription());
    }

    @Test
    void getByAuthorNameContaining() {
        Mockito.when(authorRepository.findByAuthorNameContaining("Can")).thenReturn(Arrays.asList(
                new Author("Can Yücel", "Yazar", null)
        ));

        List<Author> Authors = authorService.getByAuthorNameContaining("Can");

        assertEquals("Can Yücel", Authors.get(0).getAuthorName());
        assertEquals("Yazar", Authors.get(0).getDescription());
    }

}