package ex.service;

import java.util.Random;

import ex.dto.ExDTO;

// 기능
public class ExService {
	
	ExDTO[] students = new ExDTO[5];
	
	public ExService() {
		
	students[0] = new ExDTO("20241030", "짱구", '남'); 
	students[1] = new ExDTO("20241140", "유리", '여'); 
	students[2] = new ExDTO("20241250", "맹구", '남'); 
			
	
	Random random = new Random();
	for(ExDTO dto : students) {
		if(dto == null) {
			break;
		}
	}
		
	}
	
	
	
	public boolean addStudent(ExDTO dto) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = dto;
				return true;
			}
		}
		return false;
	}
	
	
	
}




 	