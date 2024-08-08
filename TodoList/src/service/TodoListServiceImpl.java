package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoService{ 
	
	// 인터페이스는 객체 생성 불가
	private TodoListDao dao = null;
	
	// 기본생성자
	public TodoListServiceImpl() throws FileNotFoundException, 
										ClassNotFoundException, 
										IOException {
	// 기본생성자 호출시 TodoListDao 객체 생성	
	dao = new TodoListDaoImpl();	

}

	@Override
	public Map<String, Object> todoListFullView() {
		
		// 할 일 목록 얻어오기
		List<Todo> todoList = dao.todoListFullView();
		
		int completeCount = 0;
		
		for(Todo todo : todoList) {
			completeCount++;
		}
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		return map;
	}
	
	
	@Override
	public String dateFormat(LocalDateTime regDate) {
		
    // 날짜와 시간을 원하는 포맷으로 출력하기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = regDate.format(formatter);
		
    return formattedDateTime;
	}
	
	@Override
	public int todoAdd(String title, String detail) throws FileNotFoundException, IOException {
		
		// 라이브러리로 인한 생성자 x
		Todo todo = new Todo(title, detail, false, LocalDateTime.now());
		
		return dao.todoAdd(todo);
	}
	
	
	@Override
	public String todoDetailView(int index) {
		
		// 인덱스 전달
		Todo todo = dao.todoDetailView(index);
		
		if(todo == null) return null;
		
		// 스트링빌더를 이용한 스트링문자열 저장
		StringBuilder sb = new StringBuilder();
		
		sb.append("--------------------------------------------\n");
		sb.append( String.format("제목 : %s\n", todo.getTitle()));
		sb.append( String.format("등록일 : %s\n", dateFormat(todo.getRegDate())));
		// boolean 타입은 get이 아닌 is를 사용해서 값을 얻어옴
		// 현재 롬복으로 인해 자동으로 생성됨.
		sb.append( String.format("완료여부 : %s\n", todo.isComplete() ? "O" : "X") );
		sb.append("\n[세부 내용]\n");
		sb.append("--------------------------------------------\n");
		sb.append( String.format("%s\n", todo.getDetail()) );
		
		return sb.toString();
	}	
	
	
	
	
	@Override
	public boolean todoComplete(int index) {
		
		return dao.todoComplete(index);
	}
	
	
	
	
	// 회원 내용 수정
	@Override
	public boolean todoUdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		return dao.todoUpdate(index, title, detail);
	}
	
	
	// 회원 탈퇴
	@Override
	public String todoDelete(int index) throws FileNotFoundException, IOException {
		
		Todo deleteTarget = dao.todoDelete(index);
		
		if(deleteTarget != null) 	return deleteTarget.getTitle();
		
		return null;
	}


	

	
	
	

}
