package com.springBoot.Rest.RepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.springBoot.Rest.Dao.BookRepository;
import com.springBoot.Rest.Model.Book;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class
		
		)
class BookRepositoryTests {
	@Autowired
	private BookRepository bookRepository;
//
//	@Test
//	@Order(1)
//	public void addBookTest() {
//		Book book = new Book(9,"MySql","Johny");
//		bookRepository.save(book);
//	
//		assertThat(bookRepository.findById(9)).isEqualTo(book);
//	}
//	
	
	
	@Test
	@Order(2)
	public void getBookTest() {
		
		Book book =new Book(5,"Dennial","Angular Js");
		
		boolean actuaResultBook=bookRepository.existsById(5);
		assertThat(actuaResultBook).isTrue();
}
//	
//	@Test
//	@Order(3)
//	public void getAllTest() {
//		
//		List<Book> list =(List<Book>) bookRepository.findAll();
//		assertThat(list.size()).isGreaterThan(0);
//		}
//	
//	@Test
//	@Order(4)
//	public void updateBookTest() {
//	Book book=	 bookRepository.findById(5);
//	book.setAuthor("Benstok");
//		assertNotEquals("Dennial", bookRepository.findById(5).getAuthor());
//		}
//	 
//	@Test
//	@Order(5)
//	public void deleteBookTest() {
//		
//		bookRepository.deleteById(5);
//		assertThat(bookRepository.existsById(5)).isFalse();
//	}


	

}
