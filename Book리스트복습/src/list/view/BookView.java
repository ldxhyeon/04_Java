package list.view;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

public class BookView {
	
	Scanner sc = new Scanner(System.in);
	BookService service = new BookService();
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			
			System.out.println("1. 전체 조회");
			System.out.println("2. index로 조회");
			System.out.println("3. 책 이름으로 조회(포함)");
			System.out.println("4. 글쓴이 이름으로 조회(포함)");
			System.out.println("5. 가격으로 조회");
			System.out.println("6. 도서 책 추가하기");
			System.out.println("7. 책 제거하기");
			System.out.println("8. 책 가격 수정하기");
			System.out.println("0. 종료");
			
			System.out.println();
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			
			System.out.println();
			
			
			switch(input) {
			case 1 : selectAll();   break;
			case 2 : selectIndex(); break;
			case 3 : selectTitle();	break;
			case 4 : selectWriter();break;
			case 5 : selectPrice(); break;
			case 6 : addBook(); 	break;
			case 7 : removeBook();  break;
			case 8 : updateBook();  break;
			
			
			case 0: System.out.println("***** 프로그램 종료 *****");break;
			default: System.out.println("=-=-= 잘못 입력 =-=-="); 
			}
			
			
		}while( input!=0 );
	}
	

	private void selectAll() {
		
		System.out.println("@@@@ 전체 조회 @@@@");
		
		 List<BookDTO> books = service.selectAll();
		 
		 for(int i = 0; i < books.size(); i++) {
			 System.out.println(i+") " + books.get(i));
		 }
		
	}
	
	
	
	private void selectIndex() {
		System.out.println("\n@@@@ index로 조회 @@@@\n");
		
		System.out.println("조회할 책의 index 번호 입력 : ");
		int index = sc.nextInt();
		
		BookDTO list = service.selectIndex(index);
		
		if(list == null) {
			System.out.println("해당 인덱스에 등록된 도서가 없습니다.");
			return;
		}
		
		System.out.println("제목 : " + list.getTitle());
		System.out.println("저자 : " + list.getWriter());
		System.out.println("가격 : " + list.getPrice() + "원");
		
	}
	
	
	private void selectTitle() {
		System.out.println("\n@@@@ 책 이름으로 조회(포함) @@@@\n");
		
		System.out.println("검색한 책 제목 입력 :");
		String bookName = sc.next();
		
		List<BookDTO> title = service.selectTitle(bookName);
		
		
		
		if(title.size()==0) {
			System.out.println("=-=-=- 조회 결과가 없습니다. =-=-=-");
			return;
		}
		
		for(BookDTO result : title) {
			System.out.println(result);
		}
	}
	
	public void selectWriter() {
		System.out.println("\n@@@@ 책 이름으로 조회(포함) @@@@\n");
		
		System.out.println("검색할 글쓴이 입력 :");
		String writerName = sc.next();
		
		List<BookDTO> writerList = service.selectWriter(writerName);
		
		if(writerList.size()==0) {
			System.out.println("=-=-=- 조회 결과가 없습니다. =-=-=-");
			return;
		}
		
		for(BookDTO result : writerList) {
			System.out.println(result);
		}
	}
	
	public void selectPrice() {
		System.out.println("\n@@@@ 가격으로 조회(포함) @@@@\n");
		
		System.out.println("최소 값 입력 : ");
		int min = sc.nextInt();
		System.out.println("최대 값 입력 : ");
		int max = sc.nextInt();
		
		List<BookDTO> searchList = service.selectPrice(min, max);
		
		if(searchList.isEmpty()) {
			System.out.println("=-=-=- 조회 결과가 없습니다. =-=-=-");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
	}
	
	
	public void addBook() {
		System.out.println("\n@@@@ 책 추가하기 @@@@\n");
		
		System.out.println("제목 : ");
		String title = sc.next();
		
		System.out.println("글쓴이 : ");
		String writer = sc.next();
		sc.nextLine();
		
		System.out.println("가격 : ");
		int price = sc.nextInt();
		
		BookDTO newBook = new BookDTO(title, writer, price);
		
		boolean result = service.addBook(newBook);
		
		if(result) {
			System.out.println("***** 추가 완료 *****");
		}else {
			System.out.println("***** 추가 중 문제 발생 *****");
		}
				
				
	}
	
	public void removeBook() {
		System.out.println("\n@@@@ 책 삭제하기 @@@@\n");
		
		System.out.println("조회할 책의 index 번호 입력 : ");
		int index = sc.nextInt();
		
		BookDTO removedBook = service.removeBook(index);
		
		if (removedBook != null) {
	        System.out.println("삭제된 책: " + removedBook);
	    } else {
	        System.out.println("유효하지 않은 인덱스입니다. 책이 삭제되지 않았습니다.");
	    }
		
	}
	
	public void updateBook() {
		System.out.println("\n@@@@ 책 가격 수정하기 @@@@\n");
		
		System.out.println("수정할 책의 인덱스 입력 : ");
		int index = sc.nextInt();
		
		BookDTO updateIndex = service.updateBook(index);
		
		if(updateIndex == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.println("수정할 가격 입력 : ");
		int price = sc.nextInt();
		
		
		int beforePrice = updateIndex.getPrice();
		
		updateIndex.setPrice(price);
		
		System.out.printf("[%s] 가격이 (%d) -> (%d) 수정 되었습니다.\n",
				updateIndex.getTitle(), beforePrice, price);
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
