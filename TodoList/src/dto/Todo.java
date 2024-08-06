package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Todo implements Serializable { // 직렬화
	

	private String title; 			// 할일 제목
	 private String detail;			// 상세 내용
	 private boolean complete;  	// 완료 여부
	 private LocalDateTime regDate; // 등록 날짜 
	 
	 
	 public Todo(String title, String detail) {
		 this.title = title;
		 this.detail = detail;
		 
	}
	 
	 
	 
	 
	 

	
}
