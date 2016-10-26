package com.karthik.lib.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryDao libraryDao;
	
	@Autowired
	private LibraryRepositoryDao libraryDaoImpl;

	@Autowired
	private ReaderDao readerDao;

	@Autowired
	private LibraryRecordDao libraryRecordDao;

	@Override
	public LibraryRecord borrow(LibraryRecord record) {
		if (validateBorrow(record)) {
			BookCopy bookCopy = libraryDaoImpl.getBookCopy(record.getBookCopy().getBookCopyId());
			record.setBookCopy(bookCopy);
			record.setReader(readerDao.findOne(1));
			record = libraryRecordDao.save(record);
			return record;
		}
		return null;
	}

	private boolean validateBorrow(LibraryRecord record) {
	
		if (record.getBookCopy() == null || record.getReader() == null) {
			return false;
		}
//		if(record.getBookCopy()libraryDaoImpl.checkBookAvailability(record.getBookCopy().getBook())){
//			
//		}
		if (record.getReturnAt() == null) {
			record.setReturnAt(AppUtils.afterGivenDays(21)); // TODO: remove
																// hard coded
																// days
		}
		if(record.getTakenAt() == null) {
			record.setTakenAt(new Date());
		}
		return true;
	}

}
