package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.UserVO;

public interface UserDaoInf {

	//아이디와 비밀번호 맞는지 확인
	public int getUserJoined(UserVO vo);
	
	
}
