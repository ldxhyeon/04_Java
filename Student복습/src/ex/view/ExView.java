package ex.view;

import java.util.Scanner;

// 콘솔창
public class ExView {
	
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
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
		
		
	}
		
	
	
}
