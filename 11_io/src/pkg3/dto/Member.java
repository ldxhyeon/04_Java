package pkg3.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // 모든 필드의 getter 자동생성
@Setter // 모든 필드의 setter 자동생성
@NoArgsConstructor // 전달 인자가 없는 생성 == 기본 생성자
@AllArgsConstructor // 모든 필드에 대한 매개 변수 생성자
@ToString // toString() 오버라이딩
public class Member implements Serializable {
	
	// serialVersionUID : 직렬화 식별 번호
	// -> 직렬화 / 역직렬화 시
	// 같은 객체가 맞는지 비교할 때 사용하는 번호
	// 따로 작성 안하면 JVM 이 랜덤 값 지정
	
	// 직렬화를 위해 Serializable 인터페이스 상속
	// -> 스트림 이용 시 객체가 직렬화 되어짐
	// --> 마커 인터페이스(무슨 역할/대상임을 명시)
	private String id;
	private String pw;
	private String name;
	private int age;
	
}
