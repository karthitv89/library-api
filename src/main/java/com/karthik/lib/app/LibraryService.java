package com.karthik.lib.app;

import javax.transaction.Transactional;

public interface LibraryService {
	@Transactional
	public LibraryRecord borrow(LibraryRecord record);
}
