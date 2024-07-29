package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.BookDTO;

public class BookService {

	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	
	public BookService() {
		bookList.add(new BookDTO("자바 프로그래밍 입문", "박은종", 25000));
 		bookList.add(new BookDTO("선재 업고 튀어 대본집 세트", "이시은", 45000));
 		bookList.add(new BookDTO("THE MONEY BOOK", "토스", 19800));
 		
 		bookList.add(new BookDTO("자바의 정석", "남궁성", 35000));
 		bookList.add(new BookDTO("눈물의 여왕 대본집 세트", "박지은", 60000));
 		bookList.add(new BookDTO("삼국지 전권 세트", "이문열", 30000));
	}
	

	public List<BookDTO> selectAll() {
		return bookList;
	}


	public BookDTO selectIndex(int index) {
		
		if(index < 0 || index >= bookList.size()) {
			return null;
		}
	
		return bookList.get(index);
	}


	public List<BookDTO> selectTitle(String bookName) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if(book.getTitle().contains(bookName)) {
				searchList.add(book);
			}
		}
		
		return searchList;
	}


	public List<BookDTO>  selectWriter(String writerName) {
		
		List<BookDTO> writerList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if(book.getWriter().contains(writerName)) {
				writerList.add(book);
			}
		}
		
		return writerList;
	}


	public List<BookDTO> selectPrice(int min, int max) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			int price = book.getPrice();
			
			// price 15000 min 20000 max 30000
			if(price >= min && price <= max) {
				searchList.add(book);
			}
		}
		
		return searchList;
	}


	public boolean addBook(BookDTO newBook) {
		
		// add 메서드는 true false를 반환함
		return bookList.add(newBook);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
