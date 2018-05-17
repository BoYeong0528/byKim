/**
 * 
 */
package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * BoardServiceTest.java
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
public class BoardServiceTest {

	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardServiceInf service = new BoardService();
		BoardVO vo = new BoardVO();
		vo.setBd_title("제목");
		vo.setBd_content("내용");
		vo.setBd_bbs_seq(2);
		vo.setBd_reg_id("test1");
		vo.setPbd_seq(null);

		/***When***/
		int cnt = service.insertBoard(vo);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(1, cnt);

	}
	
	@Test
	public void getOneBoardTest() {
		/***Given***/
		BoardServiceInf service = new BoardService();
		
		/***When***/
		BoardVO vo = service.getOneBoard(18);

		/***Then***/
		assertEquals("test1", vo.getBd_reg_id());
	}
	
	@Test
	public void updateReWriteTest() {
		/***Given***/
		BoardServiceInf service = new BoardService();
		BoardVO vo = new BoardVO();
		vo.setBd_seq(18);
		vo.setBd_content("18번 재수정");
		vo.setBd_title("18번 수정");
		
		/***When***/
		int cnt = service.updateReWrite(vo);
		
		/***Then***/
		assertEquals(1, cnt);
		

	}
	
	@Test
	public void updateYNvalueTest() {
		/***Given***/
		BoardServiceInf service = new BoardService();
		
		/***When***/
		int cnt = service.updateYNvalue(46);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPageTotalCntTest() {
		/***Given***/
		BoardServiceInf service = new BoardService();

		/***When***/
		int cnt = service.getPageTotalCnt(2);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(35, cnt);

	}
	
}
