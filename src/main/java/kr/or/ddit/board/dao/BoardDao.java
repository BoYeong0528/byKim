/**
 * 
 */
package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.model.BoardVO;

/**
 * BoardDao.java
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
public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDao(){
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
	* Method : getAllBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 :
	*/
	@Override
	public List<BoardVO> getAllBoard(int page, int pageSize, int cpage) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("cpage", cpage);
		List<BoardVO> list = sqlSession.selectList("board.getAllBoard", paramMap);
		sqlSession.close();
		return list;
	}

	/**
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체 건수 조회
	*/
	@Override
	public int getBoardTotalCnt(int cpage) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.selectOne("board.getBoardTotalCnt", cpage);
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("board.insertBoard", vo);
		sqlSession.commit();
		sqlSession.close();
		return vo.getBd_seq();
	}

	/**
	* Method : getOneBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 게시글의 상세정보 가져오기
	*/
	@Override
	public BoardVO getOneBoard(int bd_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO vo = sqlSession.selectOne("board.getOneBoard", bd_seq);
		sqlSession.close();
		return vo;
	}

	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 수정하기
	*/
	@Override
	public int updateReWrite(BoardVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("board.updateReWrite", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 삭제여부 수정하기
	*/
	@Override
	public int updateYNvalue(int bd_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("board.updateYNvalue", bd_seq);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	* Method : getPageTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param cpage
	* @return
	* Method 설명 :
	*/
	@Override
	public int getPageTotalCnt(int cpage) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int total = sqlSession.selectOne("board.getBoardTotalCnt", cpage);
		sqlSession.close();
		return total;
	}

}
