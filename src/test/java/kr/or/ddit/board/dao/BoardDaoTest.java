/**
 * 
 */
package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * BoardDaoTest.java
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
public class BoardDaoTest {

	@Test
	public void getAllBoardTest() {
		/***Given***/
		BoardDaoInf dao = new  BoardDao();
		int page = 3;
		int pageSize = 10;
		int cpage = 2;
		
		/***When***/
		List<BoardVO> list = dao.getAllBoard(page, pageSize, cpage);
		
		/***Then***/
		assertEquals(1, list.size());
	}
	
	@Test
	public void getBoardTotalCntTest() {
		/***Given***/
		BoardDaoInf dao = new  BoardDao();
		int cpage = 2;
		
		/***When***/
		int res = dao.getBoardTotalCnt(cpage);
		
		/***Then***/
		assertEquals(21, res);
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardDaoInf service = new BoardDao();
		BoardVO vo = new BoardVO();
		vo.setBd_title("제목");
		vo.setBd_content("내용");
		vo.setBd_bbs_seq(2);
		vo.setBd_reg_id("test1");
		vo.setPbd_seq(0);
		
		/***When***/
		int cnt = service.insertBoard(vo);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(82, cnt);

	}
	
	@Test
	public void getOneBoardTest() {
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		
		/***When***/
		BoardVO vo = dao.getOneBoard(18);

		/***Then***/
		assertEquals("test1", vo.getBd_reg_id());
	}

	@Test
	public void updateReWriteTest() {
		/***Given***/
		BoardDaoInf service = new BoardDao();
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
		BoardDaoInf dao = new BoardDao();
		
		/***When***/
		int cnt = dao.updateYNvalue(46);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPageTotalCntTest() {
		/***Given***/
		BoardDaoInf dao = new BoardDao();

		/***When***/
		int cnt = dao.getBoardTotalCnt(2);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(35, cnt);

	}
}
