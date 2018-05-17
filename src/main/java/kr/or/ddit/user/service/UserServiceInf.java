package kr.or.ddit.user.service;

import kr.or.ddit.user.model.UserVO;

public interface UserServiceInf {

	//아이디와 비밀번호 맞는지 확인
	public int getUserJoined(UserVO vo);
	
}
