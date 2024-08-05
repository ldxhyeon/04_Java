package service;

import java.util.List;

import dto.Todo;

public interface TodoService {
	

	public abstract List<Todo> fullView();

	public abstract boolean addList(String title, String detail);



	
	

}
