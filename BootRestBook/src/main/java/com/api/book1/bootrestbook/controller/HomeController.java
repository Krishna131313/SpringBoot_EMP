package com.api.book1.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book1.bootrestbook.entity.Books;
import com.api.book1.bootrestbook.repo.BookRepo;
import com.api.book1.bootrestbook.service.BookService;

import jakarta.persistence.criteria.CriteriaBuilder.In;


@RestController
@RequestMapping("/books")
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@GetMapping("")
	public ResponseEntity<List<Books>> getAllBooks(){
		List<Books> list =  bookService.getAllBooks();
		//return bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}else{
			return ResponseEntity.of(Optional.of(list));
		}  	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
		Books book = bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(book));
		} 
	}
	
	@PostMapping("")
	public ResponseEntity<Books> createBook(@RequestBody Books books) {
		Books b = bookService.createBook(books);
		return new ResponseEntity<>(b,HttpStatus.CREATED);	
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBooks(@RequestBody Books books,@PathVariable Integer id) {
		try {
		  bookService.updateBooks(books, id);	
		  return ResponseEntity.ok().body(books);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	
	}
	

	
	

	
	
	//@RequestMapping(value = "/books",method = RequestMethod.GET)
	//@GetMapping("/books")
	//@ResponseBody
	//public Books getBooks() {
		//Books book =  new Books();
	//bookrepo.findById()
		//return book;
	
	

}
