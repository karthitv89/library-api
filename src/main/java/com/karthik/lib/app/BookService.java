package com.karthik.lib.app;

import java.util.List;

public interface BookService {
	public List<Book> findAll();

	public void saveBook(Book book);

	public Book findOne(int id);

	public void delete(int id);

	public List<Book> findByName(String name);

}
