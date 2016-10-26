package com.karthik.lib.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/reader")
public class ReaderController {

	@Autowired
	private ReaderDao readerDao;

	@RequestMapping(value = "/reader/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> save(@RequestBody Reader reader) {
		reader = readerDao.save(reader);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("reader", reader);
		return result;
	}

	@RequestMapping(value = "/reader/list", method = RequestMethod.GET)
	public Map<String, Object> listBooks() {
		ArrayList<Reader> readers = (ArrayList<Reader>) readerDao.findAll();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("readers", readers);
		return result;
	}
}
