package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import dto.Todo;
import service.TodoListServiceImpl;
import service.TodoService;

public class TodoListView {
	
	
	private TodoService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		
		try {
			
			service = new TodoListServiceImpl();
			
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
				case 1 : todoListFullView();	break;
				case 2 : break;
				case 3 : todoAdd(); 			break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				
				case 0: System.out.println("***** 프로그램 종료 *****");
				br.close();				
				
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
	
	
	
	
	private void todoListFullView() {
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		Map<String, Object> map = service.todoListFullView();
		
		// todoList는 List<Todo> 타입이지만, map에는 Object 타입으로 저장됩니다. 
		// 그러므로 다운캐스팅 사용
		List<Todo> todoList = (List<Todo>)map.get("todoList");
		
		int completeCount = (int)map.get("completeCount");
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n"
								, completeCount, todoList.size());
		
		
		for(int i = 0, len = todoList.size(); i < len; i++) {
			String title = todoList.get(i).getTitle();
			// 객체 할일이 완료여부를 확인하고 삼항연산자 후 할당
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			String regDate = service.dateFormat(todoList.get(i).getRegDate());
			System.out.printf("[%3d]  %20s    (%s)       %s\n", i, regDate, completeYN, title);
		}
		
	}
	
	private void todoAdd() throws IOException {
		System.out.println("\n===============[3. Todo Add]===============\n");
		
		System.out.println("할 일 제목 입력 : ");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성(입력 종료시 !wq 작성 후 엔터)");
		System.out.println("-----------------------------------------------");
		
		// 이 객체는 문자열을 동적으로 결합하거나 수정하는 데 사용됩니다.
		StringBuilder sb = new StringBuilder(); 
		
		while(true) {
			// 입력한 값 content 저장
			String content = br.readLine();
			
			// !wq 입력하면 종료
			if(content.equals("!wq"))  break;
			
			//content 내용을 sb에 추가하여 내용을 보여
			sb.append(content);
			// 문자열 바꿈 추가
			sb.append("\n");
		}
		
		
	}
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
