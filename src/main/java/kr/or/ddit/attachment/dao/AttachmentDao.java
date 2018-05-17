/**
 * 
 */
package kr.or.ddit.attachment.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.attachment.model.AttachmentVO;

/**
 * AttachmentDao.java
 *
 * @author "K.BoYeong"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "K.BoYeong" 최초 생성
 *
 * </pre>
 */
public class AttachmentDao implements AttachmentDaoInf{
	
	private SqlSessionFactory sqlSessionFactory;
	
	public AttachmentDao(){
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
	* Method : insertAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertAttach(AttachmentVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("att.insertAttach", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}


	/**
	* Method : getBoardAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 글의 첨부파일 가져오기
	*/
	@Override
	public List<AttachmentVO> getBoardAttach(int bd_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AttachmentVO> list = sqlSession.selectList("att.getBoartAttach", bd_seq);
		sqlSession.close();
		return list;
	}

}
