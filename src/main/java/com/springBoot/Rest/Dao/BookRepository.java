package com.springBoot.Rest.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.Rest.Model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
	

	
	
}
