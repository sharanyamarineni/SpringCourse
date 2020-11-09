package com.zemoso.springdemo.service;

import java.util.List;

import com.zemoso.springdemo.entity.Book;

public interface BookService {
	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);
}
