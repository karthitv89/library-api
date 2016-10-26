package com.karthik.lib.app;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface BookOwnRepository extends Repository<Book,Long>{
	List<Book> findByName(String name);
}