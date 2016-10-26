package com.karthik.lib.app;

public interface LibraryRepositoryDao {
	public Book checkBookAvailability(Integer bookId);
	public void borrow(Book book, Reader reader);
	public void borrow(LibraryRecord record);
	public BookCopy getBookCopy(Integer bookId);
	

}
