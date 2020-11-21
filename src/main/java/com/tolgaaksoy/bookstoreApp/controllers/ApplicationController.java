package com.tolgaaksoy.bookstoreApp.controllers;

import com.tolgaaksoy.bookstoreApp.services.AuthorService;
import com.tolgaaksoy.bookstoreApp.services.BookService;
import com.tolgaaksoy.bookstoreApp.services.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@Autowired
    BookstoreService bookstoreService;
	@Autowired
    AuthorService authorService;
	@Autowired
    BookService bookService;
	
	@GetMapping("/index")
	public String goHome(Model model) {
		Long bookstoreCount = bookstoreService.countOfBookstore();
		model.addAttribute("bookstoreCount", bookstoreCount);
		Long authorCount = authorService.countOfAuthors();
		model.addAttribute("authorCount", authorCount);
		Long bookCount = bookService.countOfBooks();
		model.addAttribute("bookCount", bookCount);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}	
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/error")
	public String error(){return "error";}
}
