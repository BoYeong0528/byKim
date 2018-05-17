package kr.or.ddit.user.service;

import static org.junit.Assert.*;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

import org.junit.Test;

public class UserServiceTest {

	@Test
	public void getUserLoginedTest() {
		UserServiceInf service = new UserService();
		UserVO vo = new UserVO();
		vo.setMem_id("b001");
		vo.setMem_pass("1004");
		
		int cnt = service.getUserJoined(vo);
		
		assertEquals(1, cnt);
	}

}
