package com.zemoso.springdemo.dao;

import java.util.List;

import com.zemoso.springdemo.entity.Book;

public interface BookDAO {
	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);
}
