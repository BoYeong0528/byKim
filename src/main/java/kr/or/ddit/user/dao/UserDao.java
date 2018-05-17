package kr.or.ddit.user.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import kr.or.ddit.user.model.UserVO;

public class UserDao implements UserDaoInf{
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getUserJoined(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.selectOne("user.getUserJoined", vo);
		sqlSession.close();
		return cnt;
	}

}
