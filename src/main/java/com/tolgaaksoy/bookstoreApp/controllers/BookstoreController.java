package com.tolgaaksoy.bookstoreApp.controllers;

import java.util.List;
import java.util.Optional;

import com.tolgaaksoy.bookstoreApp.models.Bookstore;
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

@Controller
public class BookstoreController {
	
	@Autowired
	private BookstoreService bookstoreService;

	@GetMapping("/bookstories")
	public String getBookstories(Model model, String searchKeyword) {
		try {
			if(searchKeyword != null){
				List<Bookstore> bookstoreList = bookstoreService.getByBookstoreNameContaining(searchKeyword);
				model.addAttribute("bookstories", bookstoreList);
			}
			else{
				List<Bookstore> bookstoreList = bookstoreService.getBookstories();
				model.addAttribute("bookstories", bookstoreList);
			}

			return "Bookstore";
		} catch (Exception e) {
			model.addAttribute("errorMessage","There was a problem fetching records.");
			return "404";
		}
	}	
	
	@PostMapping("/bookstories/addNew")
	public String addNewBookstore(Model model, Bookstore bookstore) {
		try {
			bookstoreService.saveBookstore(bookstore);
			return "redirect:/bookstories";
		} catch (Exception e) {
			model.addAttribute("errorMessage","The record could not be added.");
			return "404";
		}
	}
	
	@RequestMapping("bookstories/findById")
	@ResponseBody
	public Optional<Bookstore> findById(Long id) {
	  return bookstoreService.findBookstoreById(id);
	}	
	
	@RequestMapping(value="/bookstories/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateBookstore(Model model, Bookstore bookstore) {
		try {
			bookstoreService.saveBookstore(bookstore);
			return "redirect:/bookstories";
		} catch (Exception e) {
			model.addAttribute("errorMessage","The record could not be updated.");
			return "404";
		}
	}
	
	@RequestMapping(value="/bookstories/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteBookstoreById(Model model, Long id) {
		try {
			bookstoreService.deleteBookstoreById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("errorMessage","Be sure to delete all book records owned by the bookstore.");
			return "404";
		}
		return "redirect:/bookstories";
	}
}
