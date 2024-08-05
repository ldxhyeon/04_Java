package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.TestMember;

public class TestMemberDaoImpl implements TestMemberDao {

	private final String FILE_PATH = "/io_test/membership.dat";
	
	private List<TestMember> memberList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public TestMemberDaoImpl() throws FileNotFoundException,
									  IOException, 
									  ClassNotFoundException {
		
		
		// 파일이 존재하는지 검사
		File file = new File(FILE_PATH);
		
		// 파일이 있다면
		if(file.exists()) { // 존재하는 경우
			try {
				
				// ObjectInputStream을 사용하여 파일에서 객체를 읽어온다.
				// ois = new ObjectInputStream(new FileInputStream(FILE_PATH))로 스트림을 생성
				// 다시 객체로 복원하는 과정
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				// 저장된 직렬화된 데이터를 읽어와서 원래의 객체 형태로 복원하는 과정입니다.
				// 예외 발생 가능성 있으므로 예외처리 해줘야함.
				// IOException: 직렬화된 객체를 읽는 과정에서 입출력 오류가 발생하는 경우.
				// ClassNotFoundException: 직렬화된 객체의 클래스가 클래스패스에 없거나 찾을 수 없는 경우.
				//ClassCastException: 읽어온 객체를 ArrayList<Member>로 캐스팅할 때 타입이 맞지 않는 경우.

				// 저장된 객체에 파일에서 읽어와
				// 다운 캐스팅하여 memberList가 참조하게 됨.
				memberList = (ArrayList<TestMember>)ois.readObject();

			} finally {
				// try 발생하는 예외를
				// throws 구문으로 처리하면
				// catch() 구문을 작성하지 않아도 된다.
				
				if(ois != null)ois.close();
			}
		}
		
		// 파일이 존재하지 않는 경우
		else {
			// 새로운 ArrayList를 만들어서 참조
			memberList = new ArrayList<TestMember>();
		}
		
	}
		
		// 파일이 존재하지 않는 경우
	

	@Override
	public boolean addMember(TestMember member) throws IOException {
		
		memberList.add(member);
		
		
		
		
		return true; 
	}
	
	


	@Override
	public List<TestMember> getMemberList() {
		
		return memberList;
	}


	// 안녕
}
