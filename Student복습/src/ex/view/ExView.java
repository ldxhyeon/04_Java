package ex.view;

import java.util.Scanner;

import ex.dto.ExDTO;
import ex.service.ExService;

// 콘솔창
public class ExView {
	
	private Scanner sc = new Scanner(System.in);
	
	ExService service = new ExService();
	
	public void mainMenu() {
		
		do {
			System.out.println("---- 학생 관리 프로그램 ----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			
			int number = sc.nextInt();
			System.out.println();
			
			switch(number) {
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 0 : break;
			default : break;
			}
		}while( 1 > 0);
		
	}
	
	public void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.println("학번 : ");
		String studentNumber = sc.next();
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		ExDTO dto = new ExDTO(studentNumber, name, gender);
		
		boolean result = service.addStudent(dto);
		
		if(result) {
			System.out.println(name + "학생이 추가 되었습니다.");
		}else {
			System.out.println("더 이상 인원 추가가 불가능합니다.");
		}
		
		int input = sc.nextInt();
		
		if(input >= 10 && 20 >= input ) {
			System.out.println("정답");
		}else {
			System.out.println("잘못");
		}
		
	}
	
	
	
		
	
	
}
