package service;

import java.io.IOException;

public interface TestMemberService {

	public abstract boolean addMember(String name, String phone)throws IOException;

}
