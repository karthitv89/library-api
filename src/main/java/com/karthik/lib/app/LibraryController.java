package com.karthik.lib.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/librarian")
public class LibraryController {

	@Autowired
	private LibraryRepositoryDao libraryDaoImpl;

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(value = "/librarian/bookavailable/{bookId}", method = RequestMethod.GET)
	public Map<String, Object> checkBookAvailability(@PathVariable Integer bookId) {
		Map<String, Object> resultMap = null;
		Book book = libraryDaoImpl.checkBookAvailability(bookId);
		if (book != null) {
			resultMap = new HashMap<>();
			resultMap.put("available", libraryDaoImpl.checkBookAvailability(bookId));
		}
		return resultMap;
	}

	@RequestMapping(value = "/librarian/borrow/{bookCopyId}/{returnDate}", method = RequestMethod.GET)
	public Map<String, Object> borrowBook(@PathVariable Integer bookCopyId, @PathVariable String returnDate) {
		Map<String, Object> resultMap = new HashMap<>();
		DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date returnAt = null;
		try {
			returnAt = (Date) formatter.parse(returnDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LibraryRecord record = new LibraryRecord();
		BookCopy bookCopy = new BookCopy();
		bookCopy.setBookCopyId(bookCopyId);

		Reader reader = new Reader();
		reader.setId(1);

		record.setBookCopy(bookCopy);
		record.setReader(reader);
		record.setReturnAt(returnAt);

		record = libraryService.borrow(record);
		resultMap.put("borrow", record);
		return resultMap;

	}

	/*
	 * Borrow -------- book copy id person id start date end date
	 * 
	 */
}
