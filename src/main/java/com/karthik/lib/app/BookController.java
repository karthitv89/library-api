package com.karthik.lib.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("book", book);
		resultMap.put("success", "true");
		return resultMap;
	}

	@RequestMapping(value = "/book/addcopy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> saveBookCopies(@RequestBody BookCopy bookCopy) {
		Book book = bookService.findOne(1);
		List<BookCopy> bookCopies = book.getBookCopies();
		bookCopies.add(bookCopy);
		bookService.saveBook(book);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("book", bookCopy);
		return resultMap;
	}

	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}

	@RequestMapping(value = "/book/list")
	public List<Book> getBooks() {
		return bookService.findAll();
	}

	@RequestMapping(value = "/book/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = bookService.findOne(id);
		return book;
	}

	@RequestMapping(value = "/book/search/name/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		List<Book> books = bookService.findByName(name);
		return books;
	}
}
