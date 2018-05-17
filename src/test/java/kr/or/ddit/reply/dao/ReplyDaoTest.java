/**
 * 
 */
package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * ReplyDaoTest.java
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
public class ReplyDaoTest {

	/**
	* Method : getOneBoardAllReplyTest
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* Method 설명 : 해당  게시글의 댓글 가져오기
	*/
	@Test
	public void getOneBoardAllReplyTest() {
		/***Given***/
		ReplyDaoInf dao = new ReplyDao();
		
		/***When***/
		List<ReplyVO> list = dao.getOneBoardAllReply(30);
		
		/***Then***/
		assertEquals(5, list.size());

	}

	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyDaoInf dao = new ReplyDao();
		ReplyVO vo = new ReplyVO();
		vo.setRp_bd_seq(4);
		vo.setRp_mem_id("test1");
		vo.setRp_content("답글입니다");
		
		/***When***/
		int cnt = dao.insertReply(vo);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(1, cnt);

	}
}
