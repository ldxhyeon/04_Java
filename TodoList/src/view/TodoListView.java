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
			
			// 입렵 값 받기
			// 버퍼를 사용하면 한번에 읽어오기 가능
			// inputStreamReader = 입력 스트림을 문자 스트림으로 변환해주는 클래스
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
				case 2 : todoDetailView(); 		break;
				case 3 : todoAdd(); 			break;
				case 4 : todoComplete(); 		break;
				case 5 : todoUpdate();			break;
				case 6 : todoDelete();			break;
				
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
		
		System.out.println("--------------------------------------------------------------------");
		System.out.printf(" %-3s    %10s    %10s    %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		
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
			
			System.out.println("-----------------------------------------------");
			
			int index = service.todoAdd(title,sb.toString());
		}
		
	}
	

	private void todoDetailView() throws IOException {
		
		System.out.println("===============[2. Todo Detail View]===============");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		
		String todoDetail = service.todoDetailView(index);
		
		if(todoDetail == null) {
			System.out.println("### 입력한 인덱스 번호에 할 일이 존재하지 않습니다.");
			return;
		}
		
		System.out.println(todoDetail);
	}
	
	/** 할 일 완료 여부 변경 (O <-> X) 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	public void todoComplete() throws NumberFormatException, IOException {
		System.out.println("===============[4. Todo Complete]===============");
		System.out.println("O <-> X 변경할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		boolean result = service.todoComplete(index);
		
		if(result) System.out.println("[변경 되었습니다.]");
		else System.out.println("### 입력한 인덱스에 Todo가 존재하지 않습니다.");
	}
	
	
	
	public void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("\n===============[5. Todo Update]===============\n");
		System.out.println("수정할 TOdo 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		String todoDetail  = service.todoDetailView(index);
		
		if(todoDetail == null) {
			System.out.println("### 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ###");
			return;
		}
		
		System.out.println("@@@@@@@@@@@[수정 전]@@@@@@@@@@@@@@@");
		System.out.println(todoDetail);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		System.out.print("수정할 제목 : ");
		String title = br.readLine();
		
		System.out.println("\n수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-----------------------------------------------");
		
		// 여러개의 문자열을 한번에 옮기려고 사용함.
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String content = br.readLine();
			
	 		if(content.equals("!wq")) break;
	 		
	 		sb.append(content);
	 		sb.append("\n");
		}
		
		System.out.println("-----------------------------------------------");
		
		boolean result = service.todoUdate(index, title, sb.toString());
	}
	
	
	public void todoDelete() throws NumberFormatException, IOException {
		System.out.println("===============[6. Todo Delete]===============");
		System.out.println("삭제할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		String title = service.todoDelete(index);
		
		if(title != null) System.out.println("[삭제 되었습니다]");
		else System.out.println("### 입력한 인덱스에 Todo가 존재하지 않습니다 ###");
	}
	
	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
