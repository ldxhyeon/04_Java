package dao;

import java.util.List;

import dto.Todo;

public interface TodoListDao {


	public abstract List<Todo> fullView();


	public abstract boolean addlist(Todo todo);


}
