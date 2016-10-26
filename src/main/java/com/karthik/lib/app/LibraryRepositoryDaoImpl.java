package com.karthik.lib.app;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepositoryDaoImpl implements LibraryRepositoryDao {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private LibraryRecordDao LibraryRecordDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Book checkBookAvailability(Integer bookId) {
		return bookDao.findOne(bookId);
	}

	@Override
	public void borrow(Book book, Reader reader) {

	}

	@Override
	public void borrow(LibraryRecord record) {
		LibraryRecordDao.save(record);

	}

	@Override
	public BookCopy getBookCopy(Integer bookCopyId) {
		Object[] values = this.entityManager.createQuery(
				"FROM BookCopy bc JOIN bc.book WHERE bc.bookCopyId = " + bookCopyId + " AND bc.taken = 0",
				Object[].class).getSingleResult();
		if (values != null) {
			BookCopy bookCopy = (BookCopy) values[0];
			bookCopy.setBook((Book) values[1]);
			return bookCopy;
		}
		return null;
	}

}
