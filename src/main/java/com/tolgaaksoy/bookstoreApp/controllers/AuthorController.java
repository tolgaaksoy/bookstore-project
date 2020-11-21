package com.tolgaaksoy.bookstoreApp.controllers;

import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.models.Author;
import com.tolgaaksoy.bookstoreApp.services.AuthorService;
import com.tolgaaksoy.bookstoreApp.services.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthorController {

	@Autowired	private AuthorService authorService;
	@Autowired	private BookstoreService bookstoreService;


	@GetMapping("/authors")
	public String getAuthors(Model model, String searchKeyword) {
        try {
            if(searchKeyword != null){
                List<Author> authorList = authorService.getByAuthorNameContaining(searchKeyword);
                model.addAttribute("authors", authorList);
            }
            else{
                List<Author> authorList = authorService.getAuthors();
                model.addAttribute("authors", authorList);
            }

            List<Bookstore> bookstoreList = bookstoreService.getBookstories();
            model.addAttribute("bookstories", bookstoreList);

            return "Author";

        } catch (Exception e) {
            model.addAttribute("errorMessage","There was a problem fetching records.");
            return "404";
        }
	}

	@PostMapping("/authors/addNew")
	public String addNewAuthors(Model model, Author author) {
        try {
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (Exception e) {
            model.addAttribute("errorMessage","The record could not be added.");
            return "404";
        }
	}

	@RequestMapping("authors/findById")
	@ResponseBody
	public Optional<Author> findAuthorById(RedirectAttributes redirectAttributes, Long id) {
        try {
            return authorService.findAuthorById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "We couldn't process your order!");
            return null;
        }
	}

	@RequestMapping(value="/authors/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateAuthor(Author author) {
		authorService.saveAuthor(author);
		return "redirect:/authors";
	}

	@RequestMapping(value="/authors/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteAuthorById(Model model, Long id) {
		try {
			authorService.deleteAuthorById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("errorMessage","Be sure to delete all book records owned by the author.");
			return "404";
		}
		return "redirect:/authors";
	}

}
