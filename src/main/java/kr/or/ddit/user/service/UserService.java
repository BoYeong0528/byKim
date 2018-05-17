package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVO;

public class UserService implements UserServiceInf{
	
	private UserDaoInf dao;
	
	public UserService(){
		dao = new UserDao();
	}

	@Override
	public int getUserJoined(UserVO vo) {
		return dao.getUserJoined(vo);
	}

}
