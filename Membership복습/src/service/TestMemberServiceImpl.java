package service;

import java.util.List;

import dao.TestMemberDao;
import dto.TestMember;

public class TestMemberServiceImpl implements TestMemberService {
	
	private TestMemberDao dao = null;


	@Override
	public boolean addMember(String name, String phone) {
		
		List<TestMember> memberList = dao.getMemberList();
		
		for(TestMember member : memberList) {
			if( phone.equals(member.getPhone())) {
				return false;
			}
		}
		
		return false;
	}
	
}
