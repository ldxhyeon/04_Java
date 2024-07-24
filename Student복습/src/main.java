import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		// 과일 바구니 만들기
		// 과일 이름을 5개 담을 수 있는 배열을 생성하고
		// 과일 이름이 5개가 배열에 저장될 때 까지 반복
		// 단, 중복되는 과일이 존재하는 경우 추가 X

		String[] fruits = new String[5];

		Scanner sc = new Scanner(System.in);

		int index = 0;

		while (true) { // 참이면 무한반복 -> 무한 반복을 멈추는 코드가 없음
			
			System.out.print("과일 이름 입력 >>> ");
			String f = sc.nextLine(); // String 변수 = int 입력 

			boolean flag = true; // flag 초기값이 잘 못 설정되어
								 // 없는 과일을 입력해도 배열에 추가X

			// 입력 과일 f가 fruits배열에 존재하는지 확인
			
			for (int i = 0; i < index; i++) {
				if (fruits[i].equals(f)) { // String 비교를 ==( 비교 연산)으로 하여
									     // 같다 비교가 불가능
					flag = false;
					break;
				}
			}

			
			if (flag) { // true
				fruits[index] = f;
				index++;
				
			} else {
				System.out.println(f + "는 이미 바구니에 존재합니다");
			}
			
			// fruits 배열 요소에
			// 모든 값을 다 대입한 경우
			// while문 종료해야되는데 종료 구문이 누락됨
			if(index == 5) {
				break;
			}

		}

		System.out.println("과일 목록 : " + Arrays.toString(fruits));

	}
}
