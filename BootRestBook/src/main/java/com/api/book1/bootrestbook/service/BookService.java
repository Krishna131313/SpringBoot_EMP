package com.api.book1.bootrestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book1.bootrestbook.entity.Books;
import com.api.book1.bootrestbook.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookrepo;
	
	public List<Books> getAllBooks(){
		return (List<Books>) bookrepo.findAll();		
	}
	
	public Books getBookById(Integer book) {
		return bookrepo.findById(book).orElse(null);		
	}
	
	public Books createBook(Books books) {
		return bookrepo.save(books);
	}
	
	public Books updateBooks(Books books,Integer id) {
	//	return books;
	
		Books exist = bookrepo.findById(id).orElse(null);
		if(exist != null) {
			exist.setName(books.getName());
			exist.setAuthor(books.getAuthor());
			return bookrepo.save(exist);
		}else {
			return null;
		}	
	}
	
	public void deleteBook(Integer id) {
		bookrepo.deleteById(id);
	}
}
