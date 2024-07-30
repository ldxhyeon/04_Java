package pkg4.exception;

public class UserDefinedExceptionRun {

	public static void main(String[] args) {
		
		try {
			// 사용자 정의 예외 강제 발생
			throw new UserException();
		}catch(UserException e) {
			System.out.println("---- catch문 ----");
			System.out.println(e.getMessage());
		}
		
	}

}
