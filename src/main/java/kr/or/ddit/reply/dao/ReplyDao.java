/**
 * 
 */
package kr.or.ddit.reply.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import kr.or.ddit.reply.model.ReplyVO;

/**
 * ReplyDao.java
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
public class ReplyDao implements ReplyDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public ReplyDao(){
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
	* Method : getOneBoardAllReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 게시글의 댓글 가져오기
	*/
	@Override
	public List<ReplyVO> getOneBoardAllReply(int bd_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ReplyVO> list = sqlSession.selectList("reply.getOneBoardAllReply", bd_seq);
		sqlSession.close();
		return list;
	}

	/**
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("reply.insertReply", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : updateReplyYN
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param rp_seq
	* @return
	* Method 설명 : 댓글 삭제하기
	*/
	@Override
	public int updateReplyYN(int rp_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("reply.updateReplyYN", rp_seq);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	
}
