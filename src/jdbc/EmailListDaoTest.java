package jdbc;

import java.util.ArrayList;
import java.util.List;

public class EmailListDaoTest {

	public static void main(String[] args) {
		InsertTest();
		fetchListTest();
	}
	
	//row Return
	public static void fetchTest() {
		EmailListDao dao = new EmailListDao();
		EmailListVo vo = dao.fetch(2);
		System.out.println(vo.toString());
	}
	
	//row list Return
	public static void fetchListTest() {
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		
		//순회1 단순for문
		//int listSize = list.size();
		/*
		for(int i = 0; i < listSize; i++) {
			EmailListVo vo = list.get(i);
			System.out.println(vo.toString());
		}*/
		
		//순회2 foreach문
		for(EmailListVo vo:list) {
			System.out.println(vo.toString());
		}
	}
	
	//row Insert
	public static void InsertTest() {
		EmailListDao dao = new EmailListDao();
		EmailListVo vo = new EmailListVo();
		boolean result = false;
		vo.setFirstName("SeHo");
		vo.setLastName("Jo");
		vo.setEmail("newmazzingga@naver.com");
		result = dao.InsertVo(vo);
		
		if(result) {
			System.out.println(vo.getEmail() + "가 입력되었습니다.");
		} else {
			System.out.println("입력오류 -_-");
		}
	}
}
