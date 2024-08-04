package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.TestMemberDao;
import dao.TestMemberDaoImpl;
import dto.TestMember;

public class TestMemberServiceImpl implements TestMemberService {
	
	
	private TestMemberDao dao = null;
	

	@Override
	public boolean addMember(String name, String phone) throws IOException {
		
		// 1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
		List<TestMember> memberList = dao.getMemberList();
		
		for(TestMember member : memberList) {
			// 휴대폰 번호가 같은지 비교
			if( phone.equals( member.getPhone() ) ) {
				return false;
			}
		}
		
		TestMember member = new TestMember(name, phone, 0, TestMember.COMMON);
		
		// DAOO 메서드 호출 후 결과 반환 받기
		boolean result = dao.addMember(member);
		
		
		return result;
		
		
	}
	
}
