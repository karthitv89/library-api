package com.karthik.lib.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LibraryDao extends CrudRepository<LibraryRecord, Integer> {
	
//	@Query("select book from Book book join book.bookCopies copy where book.id=:bookId AND copy.taken= false")
//	public Book checkBookAvailability(Integer bookId);

}
