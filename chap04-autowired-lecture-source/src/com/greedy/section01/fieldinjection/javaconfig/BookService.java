package com.greedy.section01.fieldinjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

//	BookDAO 인터페이스를 상속받아 메소드를 재정의한 BookDAOImpl 클래스를 매개변수로 넣어 
//	인터페이스 형태의bookDAO 를 초기화 해주여 bookDAO 객체를 BookDAOImpl 형태로 사용한다.
	
	/*
	 * BookDAO *타입*의 빈으로 생성된 객체를 이 프로퍼티에 자동으로 연결해준다.
	 */
	@Autowired
	private BookDAO bookDAO;

	public BookService() {
		// TODO Auto-generated constructor stub
	}
	
	public BookService(BookDAO bookDao) {
		this.bookDAO = bookDao;
	}
	
	public List<BookDTO> selectAllBooks(){
		return bookDAO.selectBookList();
	}
	
	public BookDTO searchBookBySequence(int sequence) {
		return bookDAO.selectOneBook(sequence);
	}
	
}
