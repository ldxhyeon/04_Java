package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dto.Todo;

public interface TodoService {
	

	public abstract Map<String, Object> todoListFullView();

	public abstract String dateFormat(LocalDateTime regDate);

	public abstract int todoAdd(String title, String detail) throws FileNotFoundException, IOException;

	public abstract String todoDetailView(int index);

	public abstract boolean todoComplete(int index);

	public abstract boolean todoUdate(int index, String title, String string) throws FileNotFoundException, IOException;

	public abstract String todoDelete(int index) throws FileNotFoundException, IOException;




	
	

}
