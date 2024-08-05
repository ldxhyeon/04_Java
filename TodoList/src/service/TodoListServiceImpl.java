package service;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		
		
		Todo todo = new Todo(title, detail, false);
		
		boolean result = dao.addlist(todo);
		
		
		return result;
	}
	
	

}
