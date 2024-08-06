package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dto.Todo;

public interface TodoService {
	

	public abstract Map<String, Object> todoListFullView();

	public abstract String dateFormat(LocalDateTime regDate);




	
	

}
