package run;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1번문제
//		int sum = 0;
//		
//		int[] arr = new int[9];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = i+1;
//			System.out.print(arr[i] + " ");
//			
//			if(i % 2 == 0) {
//			
//				sum += arr[i];
//				
//			}
//		}
//		
//		System.out.println("\n짝수 번째 인덱스 합 : "  + sum);
		 
		
		
		// 2번문제
//		int sum = 0;
//		
//		int[] arr = new int[9];
//		
//		for(int i = 0; i < arr.length; i++) {
//			// 0 1 2 3 4 5 6 7 8
//			
//			arr[i] = arr.length - i;
//				
//			System.out.print(arr[i] + " ");
//			
//
//			if(i % 2 != 0) {
//			
//				sum += arr[i];
//		
//			}
//		}
//		
//		System.out.println("\n홀수 번째 인덱스 합 : "  + sum);
		
		
		// 3번 문제
//		System.out.println("배열 크기를 입력하세요.");
//		int a = sc.nextInt();
//		
//		int[] arr= new int[a];
//		
//		for(int i =0; i < arr.length; i++) {
//			System.out.print(i+1 + " ");
//		}
		
		
//		boolean found = false;
//		
//		int[] arr = new int[5];
//		
// 		for(int i = 0; i < arr.length; i++) {
// 			System.out.printf("입력 %d :", i);
// 			arr[i] = sc.nextInt();
// 		}
// 		
// 		System.out.println("검색할 값 :");
// 		int search = sc.nextInt();
// 		
// 		for(int i = 0; i < arr.length; i++) {
// 			if(arr[i] == search) {
// 				System.out.println("인덱스 : " + i);
// 				found = true;
// 			}
// 		}
// 		
// 		if(!found) {
//				System.out.println("일치하는 값이 존재하지 않습니다.");
//			}
// 		
 		
//		int sum = 0;
//		
//		System.out.println("배열길이를 입력하세요");
//		int a = sc.nextInt();
//		
//		int[] arr = new int[a];
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.printf("배열 %d번쨰 인덱스에 넣을 값 : ",i);
//			arr[i] = sc.nextInt();
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+ " ");
//			sum += arr[i];
//		}
//		
//		System.out.println("\n총합 : " + sum);
		
		
		
		
		
		
		
//		char[] arr = new char[14];
//		
//		System.out.print("주민등록번호(-포함) : ");
//		String str = sc.next();
//		
//		// 주민등록번호를 char 배열 요소로 하나씩 대입
//		for(int i = 0 ; i < str.length() ; i++) {
//			if(i <= 7) 	arr[i] = str.charAt(i); // 성별 까지
//			else		arr[i] = '*';			// 성별 이후
//			
//			System.out.print(arr[i]); // 출력
//		}
		
		
//		char[] arr = new char[14];
//		System.out.println("주민등록번호(-포함)");
//		String str = sc.next();
//		
//		for(int i = 0; i < str.length(); i++) {
//			if( i <= 7) {
//				arr[i] = str.charAt(i);
//			}else {
//				arr[i] = '*';
//			}
//			
//			System.out.print(arr[i]);
//		}
		
		
		
		
//		int n;
//		
//		
//		while(true) {
//			
//			System.out.print("정수 : ");
//			n = sc.nextInt();
//			
//			if(n >= 3 && n % 2 != 0) {
//				int[] arr = new int[n];
//				int mid = n / 2;
//				
//				// i + 1= 0+1, 1+1 2+1 이니까 3
//				// arr[0] == 1
//				// arr[1] == 2
//				// arr[2] == 3
//				
//				for (int i = 0; i <= mid; i++) {
//                    arr[i] = i + 1;
//                }
//				
//				
//				// 2+1 == i
//				// 3 < 5이므로 3,4 
//				// arr[3] == 5-3 이므로 2 
//				// arr[4] == 4-3 이므로 1
//                for (int i = mid + 1; i < n; i++) {
//                    arr[i] = n - i;
//                }
//
//                // 배열 출력
//                for (int i = 0; i < n; i++) {
//                    System.out.print(arr[i] + " ");
//                }
//                System.out.println(); // 줄 바꿈 추가
//
//                break; // 유효한 입력을 받았으므로 루프 종료
//				
//				
//			}else {
//				System.out.println("다시 입력하세요.");
//			}
//			
//		}
		
		
		
//		int[] arr = new int[10];
//		
//		System.out.print("발생한 난수  : ");
//		for(int i = 0; i < arr.length; i++) {
//			
//			arr[i] = (int)Math.floor(Math.random() * 10 + 1);
//			
//			System.out.print(arr[i] + " ");
//			
//		}
		
		
		int[] arr = new int[10];
		
		
		System.out.print("발생한 난수  : ");
		
		
		for(int i = 0; i < arr.length; i++) {
		
			arr[i] = (int)Math.floor(Math.random() * 10 + 1);
			// 1부터 10 난수
			
			System.out.print(arr[i] + " ");
		}
		
		
		int max = arr[0];
		
		
		int min = arr[0];
		
		
		
		for (int i = 1; i < arr.length; i++) {
			
            if (arr[i] > max) {
            	
                max = arr[i];
            }
				
            
            if (arr[i] < min) {
                min = arr[i];
            }
        }
		
		// 결과 출력
        System.out.println("\n최대값: " + max);
        System.out.println("최소값: " + min);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 
		
		
		
		
	}
}
