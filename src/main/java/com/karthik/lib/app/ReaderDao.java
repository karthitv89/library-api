package com.karthik.lib.app;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ReaderDao extends CrudRepository<Reader, Integer> {

}
