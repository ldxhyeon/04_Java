package dao;

import java.io.IOException;
import java.util.List;

import dto.TestMember;

public interface TestMemberDao {

	
	

	/**
	 * 회원 추가
	 * @param member
	 * @return true
	 * @throws IOException
	 */
	boolean addMember(TestMember member) throws IOException;
	
	

	List<TestMember> getMemberList();
}
