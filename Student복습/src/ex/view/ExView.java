package ex.view;

import java.util.Scanner;

import ex.dto.ExDTO;
import ex.service.ExService;

// 콘솔창보여지는 용도
// == 클라이언트의 입력 / 출력을 담당하는 클래스
public class ExView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	private ExService service = new ExService();
	
	/*
	 * 메인메뉴
	 */
	public void mainMenu() {
		
		
		int input = 0; // 입력 받은 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그렘 ----- \n");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >>");
			
			
			input = sc.nextInt();
			sc.nextLine();
			
			
			System.out.println();
			
			
			
			switch(input) {
			case 1: addStudent();	break;
			case 2: allStudent(); 	break;
			case 3: selectIndex(); 	break;
			case 4: selectName();	break;
			case 5: updateIndex();  break;
			case 6: break;
			case 7: break;
			
			case 0: System.out.println("*** 프로그램 종료 ***");break;
			default: System.out.println("*** 메뉴 번호 잘못 입력 ***");break;
			}
			
			
		}while(input != 0);
	}
	
	
	
	private void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.println("학번 : ");
		String studentNumber = sc.next(); 
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		ExDTO std = new ExDTO(studentNumber, name, gender); 
		
		boolean result = service.addStudent(std);
		
		
		if(result) {
			System.out.println(name + " 학생이 추가 되었습니다. ");
		}else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
		
		
	}
	
	
	public void allStudent() {
		
		System.out.println("\n----- 학생 전체 조회 -----\n");
		
		
		ExDTO[] students = service.getStudents();
		
		for(ExDTO std : students) {
			if(std == null) {
				return;
			}
			
			System.out.println(std.toString());
			System.out.println("------------------------");
		}
	
	}
	
	
	
	public void selectIndex() {
		
		System.out.println("\n----- 학생 1명 조회 -----\n");
		
		System.out.println("조회할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		ExDTO std = service.selectIndex(index);
		
		if(std == null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
		}
		
		System.out.println(index + "번째 학생 정보");
		
		// ExDTO 클래스에서 toString() 메서드를 오버라이드하지 않았다면, 
		// Object 클래스의 기본 toString()이 호출되어 객체의 클래스 이름과 해시코드가 출력됩니다.
		System.out.println(std.toString());
	}
	
	public void selectName() {
		
		System.out.println("\n----- 이름으로 조회 -----\n");
		
		System.out.println("검색할 학생 이름 ");
		String name = sc.next();
		
		ExDTO std = service.selectName(name);
		
		if(std == null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		System.out.println(std.toString());
		
	}
	
	public void updateIndex() {
		System.out.println("수정할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("HTML, CSS, JS, JAVA 순서로 점수 입력 : ");
		int html = sc.nextInt();
		int css = sc.nextInt();
		int js = sc.nextInt();
		int java = sc.nextInt();
		
		
	}
	
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
