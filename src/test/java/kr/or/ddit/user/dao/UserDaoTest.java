package kr.or.ddit.user.dao;

import static org.junit.Assert.*;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVO;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void getUserLoginedTest() {
		UserDaoInf dao = new UserDao();
		UserVO vo = new UserVO();
		vo.setMem_id("b001");
		vo.setMem_pass("1004");
		
		int cnt = dao.getUserJoined(vo);
		
		assertEquals(1, cnt);
	}

}
