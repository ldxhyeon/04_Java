package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	
	public void saveFile() throws FileNotFoundException, IOException {
		
		// 예외는 throws를 던져 버리기 때문에 catch문 불필요
		try {
			// 객체를 파일에 저장
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			// 파일에 객체 쓰고 저장
			oos.writeObject(todoList);
		} finally {
			oos.close(); // 예외 발생 여부 관계 없이 무조건 닫기
		}
	}
	
	

	@Override
	public List<Todo> todoListFullView() {
		
		return todoList;
	}
	
	
	@Override
	public int todoAdd(Todo todo) throws FileNotFoundException, IOException {
		// 객체 출력 스트림 생성
		if(todoList.add(todo)) {
			saveFile();
			return todoList.size() -1; // 마지막 인덱스 번호 반환
		}
		return -1;
	}
	
	@Override
	public Todo todoDetailView(int index) {
		
		// 인덱스가 0보다 작거나 인덱스가 사이즈보다 크면 안되는 조건
		if(index < 0 || index >= todoList.size()) {
			return null;
		}
		
		return todoList.get(index);
	}
	
	@Override
	public boolean todoComplete(int index) {
		
		if(index < 0 || index >= todoList.size()) return false;
		
		// 입력된 인덱스에 isComplete(); 값 가져오기
		// 기본값 false로 설정 됨.
		boolean complete = todoList.get(index).isComplete();
		// 해당 인덱스에 complete값을 false의 반대인 true로 설정.
		todoList.get(index).setComplete(!complete);
		
		// 완료가 되면 true
		// 실패하면 false 반환
		return true;
	}
	
	
	@Override
	public boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		// 수정된 내용 + 이전 Todo의 완료 여부, 등록일을 담은 Todo 객체 생성 
		Todo newTodo = new Todo();
		
		newTodo.setTitle(title);
		newTodo.setDetail(detail);
		newTodo.setComplete(todoList.get(index).isComplete());
		newTodo.setRegDate(todoList.get(index).getRegDate());
		
		//set(index, newTodo): 리스트의 index 위치에 있는 요소를 
		// newTodo로 교체하고, 교체되기 전의 요소를 반환
		// 교체되기 전 값이 null이 아니면 밑에 코드 실행
		if(todoList.set(index, newTodo) != null) {
			
			// 변경 내용이 발생 했으므로 파일을 새로 저장
			saveFile();
			
			
			return true;
		}
		
		
		return false;
	}
	
	
	@Override
	public Todo todoDelete(int index) throws FileNotFoundException, IOException {
		
		if(index < 0 || index >= todoList.size()) return null;
		
		Todo deletedTarget = todoList.remove(index);
		
		saveFile();
		
		return deletedTarget;
	}



	
			
	
	

	

	
	
	
}
