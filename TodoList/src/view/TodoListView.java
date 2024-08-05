package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dao.TodoListDaoImpl;
import dto.Todo;
import service.TodoService;

public class TodoListView {
	
	
	private TodoService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		
		try {
//			service = new TodoListDaoImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		}catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); 
		}
		
	}

	public void mainMenu() {
		
		int input = 0;
		
		
		do {
			try {
				
				input = selectMenu();
				
				switch(input) {
				case 1 : fullView();	break;
				case 2 : break;
				case 3 : addList(); 	break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				
				case 0: System.out.println("***** 프로그램 종료 *****");
				default : System.out.println("### 메뉴에 작성된 번호만 입력 해주세요.");
				}
				
				
			} catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요. ###\n");
				input = -1;
				
			} catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외. ###\n");
				e.printStackTrace();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		}while(input != 0);
		
		
		
	}
	

	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n====== Todo List =====\n");
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.println("select menu number >>>");
		
		int input = Integer.parseInt( br.readLine() );
		System.out.println();
		
		return input;
	}
	
	
	
	
	private void fullView() {
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		System.out.println("[ 완료된 Todo 개수 / 전체 Todo 수 : 2 / 5 ]");
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-10s %-10s %8s %12s \n",
				"[인덱스]", "[등록일]", "[완료여부]", "[할일제목]");
		
		
		
		List<Todo> list = service.fullView();
		
		System.out.println(list);
			
		
	}
	
	private void addList() throws IOException {
		System.out.println("\n===============[3. Todo Add]===============\n");
		System.out.println("할 일 제목 입력");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		String detail = br.readLine();
		
		boolean result = service.addList(title, detail);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
