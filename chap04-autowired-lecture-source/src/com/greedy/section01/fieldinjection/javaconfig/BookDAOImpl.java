package com.greedy.section01.fieldinjection.javaconfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO{

	private Map<Integer, BookDTO> bookList;
	
	public BookDAOImpl() {
		bookList = new HashMap<Integer, BookDTO>();
		bookList.put(1, new BookDTO(1, 123456, "자바의정석", "김선웅", "웅출판", new Date()));
		bookList.put(2, new BookDTO(2, 312456, "코틀린의정석", "김선웅", "김출판", new Date()));
		bookList.put(3, new BookDTO(3, 523456, "칭찬의정석", "김선웅", "선출판", new Date()));
	}
	
	@Override
	public List<BookDTO> selectBookList() {
		
		return new ArrayList<BookDTO>(bookList.values());
	}

	@Override
	public BookDTO selectOneBook(int sequence) {
		return bookList.get(sequence);
	}
	
	

}
