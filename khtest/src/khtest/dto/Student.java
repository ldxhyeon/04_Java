package khtest.dto;

public class Student {
	
	private String name;
	private int score;
	
	
	// 매개변수로 받을 생성자가 없음
	public Student(String name, int score) {
		
		this.name = name;
		
		this.score = score;
		
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + "학생의 점수 : " + score + "점";
	}
	

	
	
}