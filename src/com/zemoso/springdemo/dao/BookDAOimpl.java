package com.zemoso.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zemoso.springdemo.entity.Book;

@Repository
public class BookDAOimpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> query = currentSession.createQuery("from Book",Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public void saveBook(Book theBook) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theBook);
	}

	@Override
	public Book getBook(int theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Book theBook = currentSession.get(Book.class, theId);
				
				return theBook;
	}

	@Override
	public void deleteBook(int theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Book where id=:bookId");
				theQuery.setParameter("bookId", theId);
				
				theQuery.executeUpdate();
	}


}
