package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListDao {



	public abstract List<Todo> todoListFullView();

	public abstract int todoAdd(Todo todo) throws FileNotFoundException, IOException;

	public abstract Todo todoDetailView(int index);

	public abstract boolean todoComplete(int index);

	public abstract boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException;

	public abstract Todo todoDelete(int index) throws FileNotFoundException, IOException;
	


}
