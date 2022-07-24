package com.springBoot.Rest.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.Rest.Model.Book;
import com.springBoot.Rest.Services.BookServices;

@RestController
public class BookController {
	@Autowired
	private BookServices bookServices;
	
//	get All Books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
	List<Book> list =bookServices.getAllBooks();
	if (list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}

		return  ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
//	get Book By id
	@GetMapping("/books/{id}")
   public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		
	Book  book =bookServices.getBookById(id);
		if (book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	return ResponseEntity.of(Optional.of(book));
}
//	add new Book 
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b =null;
		try {
		b=	this.bookServices.addBook(book);
		return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	Delete book 
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) 
	{
		try {
			this.bookServices.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
//	update data 
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("id") int id) 
	{
		
		try {
			this.bookServices.updateBook(book ,id);
			return ResponseEntity.status(HttpStatus.OK).build();

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
				
	}
}
