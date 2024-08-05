package service;

import java.io.IOException;
import java.util.List;

import dto.TestMember;

public interface TestMemberService {

	public abstract boolean addMember(String name, String phone)throws IOException;

	public abstract List<TestMember> getMemberList();
	


}
