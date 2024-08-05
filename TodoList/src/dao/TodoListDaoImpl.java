package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao{
	
	private List<Todo> memberList = new ArrayList<Todo>();
	
	
	public TodoListDaoImpl() {
	}
	
	
	
	

//	@Override
//	public List<Todo> fullView() {
//		
//		List<Todo> todos = new ArrayList<>();
//        todos.add(new Todo("2024-08-01", "Buy groceries", false));
//        todos.add(new Todo("2024-08-02",  "Complete homework",false));
//		
//		return todos;
//	}
	
	
	



	@Override
	public boolean addlist(Todo todo) {
		
		
		memberList.add(todo);
		
		return true;
	}
		


	@Override
	public List<Todo> fullView() {
		
		
		return memberList;
	}
	

	
	
	
}
