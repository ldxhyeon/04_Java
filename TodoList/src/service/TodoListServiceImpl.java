package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoService{ 
	
	private TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, 
										 ClassNotFoundException, 
										 IOException {
	dao = new TodoListDaoImpl();	

}
	
	@Override
	public List<Todo> fullView() {
		
		
		return dao.fullView();
	}

	@Override
	public boolean addList(String title, String detail) {
		
		
		Todo todo = new Todo(title, detail);
		
		boolean result = dao.addlist(todo);
		
		
		return result;
	}
	
	@Override
	public String dateFormat(LocalDateTime regDate) {
		
    // 날짜와 시간을 원하는 포맷으로 출력하기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = regDate.format(formatter);
		
    return formattedDateTime;
	}
	
	

}
