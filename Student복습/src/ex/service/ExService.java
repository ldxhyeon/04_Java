package ex.service;

import java.util.Random;

import ex.dto.ExDTO;

// 기능(비즈니스 로직) 제공용 클래스
public class ExService {
	
	
	// StudentDTO 객체를 참조하는
	// StudentDTO 참조 변수 5개 묶음 배열 생성
	// 인덱스 : 0 ~ 4 
	// 각 인덱스 요소 : 초기 값 null
	private ExDTO[] students = new ExDTO[5];
	
	public ExService() {
		
		students[0] = new ExDTO("24001", "짱구", '남');
		students[1] = new ExDTO("24002", "유리", '여');
		students[2] = new ExDTO("24003", "맹구", '남');
		
		Random random = new Random();
		
		for(ExDTO std : students) {
			// 현재 접근한 요소가 참조하는 객체가 없다면
			// 반복을 종료
			if(std == null) {
				break;
			}
			
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
		
	}
	
	/**
	 *
	 * @param std
	 * @return
	 */
	public boolean addStudent(ExDTO std) {
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) { // i번쨰 요소가 비어있는 경우
				students[i] = std;
				return true;
			}
		}
		
		return false;
	
	}
	
	public ExDTO[] getStudents() {
		return students;
	}
	
	
	public ExDTO selectIndex(int index) {
		
		if(index < 0 || index >= students.length) {
			return null;
		}
		
		return students[index];
		
	}
	
	public ExDTO selectName(String name) {
		
		
		
		for(ExDTO std : students) {
			if( std == null ) {
				return null;
			}
			
			if(std.getName().equals(name)) {
				return std;
			}
		}
		
		return null;
	}
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




 	