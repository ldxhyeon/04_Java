package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.TestMemberService;
import service.TestMemberServiceImpl;

public class TestMemberView {

	private TestMemberService service = null;
	private BufferedReader br = null;
	
	public TestMemberView() {
		
		try {
			service = new TestMemberServiceImpl();
			
			// BufferedReader  효율적?으로 읽어오는..
			// new InputStreamReader : 키보드 입력값을 문자열로 읽는..
			br = new BufferedReader(new InputStreamReader(System.in));
			
			
		}catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	// --------------------------------------------------------------------
	// [메인 메뉴]
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
				
				input = selectMenu();
				
				switch(input) {
				case 1 : addMember(); break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 7 : break;
				
				case 0 : System.out.println("***** 프로그램 종료 *****"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력 해주세요.");
				}
				
				
				
			} catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요. ###\n");
				input = -1;
				
			} catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외. ###\n");
				e.printStackTrace();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}while(input != 0);
	}
	
	
	public int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n===== 회원 관리 프로그램 =====\n");
		
		System.out.println("1.회원 가입(추가)");
		System.out.println("2.회원 전체 조회");
		System.out.println("3.이름 검색(동명이인 있으면 모두 조회)");
		System.out.println("4.특정 회원 사용 금액 누적하기");
		System.out.println("5.회원 정보 수정");
		System.out.println("6.회원 탈퇴");
		System.out.println("0.프로그램 종료");
		
		System.out.println("메뉴 선택 >>>> ");
		
		int input = Integer.parseInt( br.readLine() );
		System.out.println();
		
		return input;
	}
	
	
	private void addMember() throws IOException {
		System.out.println("\n----- 회원 가입(추가) ------\n");
		
		System.out.println("이름 : ");
		String name = br.readLine();
		
		String phone = null;
		
		while(true) {
			System.out.println("휴대폰 번호(-제외) : ");
			phone = br.readLine();
			
			if(phone.length() != 11) {
				System.out.println("*** 다시 입력해주세요. ***");
				continue;
			}
			
			break;
		}
		
		boolean result = service.addMember(name,phone);
		
		System.out.println(result);
	}
	
	// 프로그래밍 언어응용 - 문제 해결 시나리오
	
	// 8월 5일
	
	// - 문제 원인
	// 1) 어디서 발생했는가
	// 2) 어떠한 이유로 발생했는가
	
	// - 조치 내용
	// 1) 해결 방법에 대한 설명
	// 2) 오류가 해결된 코드
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
