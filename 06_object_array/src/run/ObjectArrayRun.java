package run;

import service.MemberService;

public class ObjectArrayRun {
	public static void main(String[] args) {
		
		// MemberService 객체 생성
		// -> MemberService 기본 생성자를 작성한 적 없다.
		// --> 생성자가 없으면 자동으로 컴파일러가 만들어준다
		MemberService service = new MemberService();
		
		service.method1();
	}
}
