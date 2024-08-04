package dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestMember implements Serializable {

	// 상수 변하지 않는 값.
	public static final int COMMON = 0;
	public static final int GOLD = 0;
	public static final int DIAMOND = 0;
	
	private String name;
	private String phone;
	private int amount;
	private int grade;
	
	
	
	
	
}
