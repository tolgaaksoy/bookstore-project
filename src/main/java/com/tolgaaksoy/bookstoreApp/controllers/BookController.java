package com.tolgaaksoy.bookstoreApp.controllers;

import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.dto.BookDto;
import com.tolgaaksoy.bookstoreApp.models.Author;
import com.tolgaaksoy.bookstoreApp.models.Book;
import com.tolgaaksoy.bookstoreApp.models.Bookstore;
import com.tolgaaksoy.bookstoreApp.services.AuthorService;
import com.tolgaaksoy.bookstoreApp.services.BookService;
import com.tolgaaksoy.bookstoreApp.services.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping("/books")
    public String getBooks(Model model, String searchTitle, String searchKeyword) {
        try {
            if (searchKeyword != null) {
                List<Book> bookList = bookService.searchBook(searchTitle, searchKeyword);
                model.addAttribute("books", bookList);
            } else {
                List<Book> bookList = bookService.getBooks();
                model.addAttribute("books", bookList);
            }
            List<Bookstore> bookstoreList = bookstoreService.getBookstories();
            model.addAttribute("bookstories", bookstoreList);

            List<Author> authorList = authorService.getAuthors();
            model.addAttribute("authors", authorList);

            return "Book";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "There was a problem fetching records.");
            return "404";
        }
    }

    @PostMapping("/books/addNew")
    public String addNew(Model model, BookDto bookDto) {
        try {
            System.out.println(bookDto);
            bookService.saveBook(bookDto);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "The record could not be added.");
            return "404";
        }
    }

    @RequestMapping("books/findById")
    @ResponseBody
    public Optional<Book> findBookById(Long id) {
            return bookService.findBookById(id);
    }

    @RequestMapping(value = "/books/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Model model, BookDto bookDto) {
        try {
            bookService.saveBook(bookDto);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "The record could not be updated.");
            return "404";
        }
    }

    @RequestMapping(value = "/books/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteAuthorById(Model model, Long id) {
        try {
            bookService.deleteAuthorById(id);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "The record could not be deleted.");
            return "404";
        }
    }
}
