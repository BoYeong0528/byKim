/**
 * 
 */
package kr.or.ddit.bbs.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.bbs.model.BbsVO;

/**
 * BbsDao.java
 *
 * @author "K.BoYeong"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "K.BoYeong" 최초 생성
 *
 * </pre>
 */
public class BbsDao implements BbsDaoInf{
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BbsDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	/**
	* Method : getBbsList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<BbsVO> getBbsList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BbsVO> list = sqlSession.selectList("bbs.getBbsList");
		sqlSession.close();
		return list;
	}

	/**
	* Method : insertBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시판 추가하기
	*/
	@Override
	public int insertBbs(BbsVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("bbs.insertBbs", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : updateBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bbs_seq
	* @return
	* Method 설명 : 게시판 활성화여부 변경
	*/
	@Override
	public int updateBbs(int bbs_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("bbs.updateBbs", bbs_seq);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : getAllBbsList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<BbsVO> getAllBbsList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BbsVO> list = sqlSession.selectList("bbs.getAllBbsList");
		sqlSession.close();
		return list;
	}

}
