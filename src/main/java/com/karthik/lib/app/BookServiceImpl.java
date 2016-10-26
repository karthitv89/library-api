package com.karthik.lib.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookOwnRepository bookOwnRepository;

	public List<Book> findAll(){
		return (List<Book>) bookDao.findAll();
	}
	public List<Book> findByName(String name){
		return bookOwnRepository.findByName(name);
	}
	public void saveBook(Book book){
		bookDao.save(book);
	}
	public Book findOne(int id){
		return bookDao.findOne(id);
	}
	public void delete(int id){
		bookDao.delete(id);
	}
}