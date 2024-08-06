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


	

	
	
	

}
