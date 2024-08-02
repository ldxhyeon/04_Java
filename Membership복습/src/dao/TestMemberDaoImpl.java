package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import dto.TestMember;

public class TestMemberDaoImpl implements TestMemberDao {

	private final String FILE_PATH = "/io_test/membership.dat";
	
	private List<Member> memberList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public TestMemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		// 파일이 존재하는지 검사
		File file = new File(FILE_PATH);
		
		// 파일이 있다면
		if(file.exists()) {
			try {
				// 파일을 읽어오기 위한 인스턴스 생성
				// 예외 발생 가능성 있으므로 예외처리 해줘야함.
				// IOException과 ClassNotFoundException을 발생
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				// 저장된 직렬화된 데이터를 읽어와서 원래의 객체 형태로 복원하는 과정입니다.
				// 예외 발생 가능성 있으므로 예외처리 해줘야함.
				memberList = (ArrayList<Member>)ois.readObject();
			} finally {
				
				
					try {
						if(ois != null)ois.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			}
			
		}
	}
	
	@Override
	public List<TestMember> getMemberList() {
		
		return null;
	}
	
}
