package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao{
	
	private final String FILE_PATH = "TodoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public TodoListDaoImpl() throws IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		// 파일이 존재하지 않으면 ArrayList로 초기화
		if(!file.exists()) {
			todoList = new ArrayList<Todo>();
			
		// 파일이 있으면 
		}else {
			try {
				// FileInputStream: 파일에서 바이트 단위로 데이터를 읽기 위한 스트림
				// ObjectInputStream : 바이트 스트림으로부터 객체를 읽기 위한 스트림
				// 객체 직렬화를 통해 저장된 객체를 역직렬화하여 메모리로 가져옴
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				// 객체 입력 스트림에서 읽어온 객체
				todoList = (ArrayList<Todo>)ois.readObject();
				
			}finally {
				if(ois != null) ois.close();
			}
		}
		
	}
	
	

	@Override
	public List<Todo> todoListFullView() {
		
		return todoList;
	}
			
	
	

	

	
	
	
}
