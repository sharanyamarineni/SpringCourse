package com.zemoso.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springdemo.entity.Book;
import com.zemoso.springdemo.service.BookService;

@Controller
@RequestMapping(name="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(name="/list")
	public String listBooks(Model model) {
		List<Book> theBooks = bookService.getBooks();
		model.addAttribute("books",theBooks);
		return "list-books";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "add-form";
	}
	
	@PostMapping("/saveBook")
	public String saveCustomer(@ModelAttribute("book") Book theBook) {
		
		// save the customer using our service
		bookService.saveBook(theBook);
		
		
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Book theBook = bookService.getBook(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("book", theBook);
		
		// send over to our form		
		return "add-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("bookId") int theId) {
		
		// delete the customer
		bookService.deleteBook(theId);
		
		return "redirect:/";
	}
}
