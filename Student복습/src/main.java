import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

	
		
		
//		Scanner sc = new Scanner(System.in);
//		String[] fruits = new String[5];
//		
//		int index = 0;
//		
//		while(true) {
//			
//			
//			System.out.print("과일 입력 : ");
//			String f = sc.next();
//			
//			boolean result = true;
//			
//			for(int i = 0; i < index; i++) {
//				
//				
//				
//				// 0 번 값 문자랑 문자열
//				if(fruits[i].equals(f)) {
//					result = false;
//				}else {
//					result = true;
//				}
//			}
//			
//			if(result) {
//				fruits[index] = f;
//				index++;
//				
//			}else {
//				System.out.println(f + "과일이 이미 담겨져 있습니다.");
//			}
//			
//			if(index == 5) {
//				System.out.println("바구니가 가득 찼습니다.");
//				break;
//			}
//			
//			 
//			
//		}
//		
//		System.out.println("과일 목록 : " + Arrays.toString(fruits));
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		String[] memberArr = {"홍길동", "김성훈", "윤웅식", "윤성우", "남궁인"};
		
		System.out.println("검색할 회원 이름을 입력하세요 : ");
		
		// int 타입으로 돼 있음
		String searchName = sc.next();
		
		
		boolean result = false;
		
		
		// 1 이 아닌  0의 값 부터 시작
		for(int i = 0; i < memberArr.length; i++) {
			// 0번이 네임과 같으면 
			if(memberArr[i].equals(searchName)) {
				// false 반환
				result = false;
				break;
			}else {
				result = true;
			}
			
		}
		
		if(result) {
			System.out.println("회원이 존재하지 않습니다.");
		}else {
			System.out.println("회원이 존재합니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		

	}
}
