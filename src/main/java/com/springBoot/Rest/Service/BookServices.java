package com.springBoot.Rest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springBoot.Rest.Dao.BookRepository;
import com.springBoot.Rest.Model.Book;

@Service
public class BookServices {
	@Autowired
	private BookRepository bookRepository;

	@Cacheable(value = "books")
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;

	}

	@Cacheable(cacheNames = "books", key = "#id")
	public Book getBookById(int id) {
		Book book = null;
		try {
			// book= list.stream().filter(e->e.getId()==id).findFirst().get();

			book = this.bookRepository.findById(id);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book b) {
		Book result = bookRepository.save(b);

		return result;

	}

	@CacheEvict(value = "books", key = "#id")
	public void deleteBookById(int id) {
		// list.stream().filter(e->e.getId()==id).collect(Collectors.toList());
		bookRepository.deleteById(id);

	}

	@CachePut(cacheNames = "books", key = "#id")
	public void updateBook(Book book, int id) {

		book.setId(id);
		bookRepository.save(book);
	}

}
