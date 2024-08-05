package khtest.run;

import java.util.ArrayList;

import khtest.dto.Student;

public class Test {
	public static void main(String[] args) {
		
		
		// null은 초기화가 아닌
		// 객체가 없다는 의미이므로
		// 초기화 코드로 변경
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("강건강", 84));
		list.add(new Student("남나눔", 78));
		list.add(new Student("도대담", 96));
		list.add(new Student("류라라", 67));
		
		
		// 사이즈로 해야함
		for(int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(s);
		}
	}
}
