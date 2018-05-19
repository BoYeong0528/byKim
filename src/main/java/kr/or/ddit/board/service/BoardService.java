/**
 * 
 */
package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;

/**
 * BoardService.java
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
public class BoardService implements BoardServiceInf{
	
	private BoardDaoInf dao;
	
	public BoardService(){
		dao = new BoardDao();
	}

	/**
	* Method : getBoardPageList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param cpage
	* @return
	* Method 설명 :
	*/
	@Override
	public Map<String, Object> getAllBoard(int page, int pageSize, int cpage) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVO> list = dao.getAllBoard(page, pageSize, cpage);
		String pageNav = makePageNav(page, dao.getBoardTotalCnt(cpage), cpage);
		resultMap.put("pageList", list);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
//	@Override
//	public List<BoardVO> getAllBoard(int page, int pageSize, int cpage) {
//		List<BoardVO> list = dao.getAllBoard(page, pageSize, cpage);
//		String pageNav = makePageNav(page, dao.getBoardTotalCnt(cpage), cpage);
//		return list;
//	}

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
		return dao.insertBoard(vo);
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
		return dao.getOneBoard(bd_seq);
	}

	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :게시글 수정하기
	*/
	@Override
	public int updateReWrite(BoardVO vo) {
		return dao.updateReWrite(vo);
	}

	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :게시글 삭제여부 수정하기
	*/
	@Override
	public int updateYNvalue(int bd_seq) {
		return dao.updateYNvalue(bd_seq);
	}

	
	
	/**
	* Method : makePageNav
	* 최초작성일 : 2018. 5. 4.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param page
	* @param userCnt
	* Method 설명 : 페이지 네비게이션 생성
	*/
	private String makePageNav(int page, int usertotalcnt, int cpage) {
		
		int pageToTalCnt = (int) Math.ceil( (double)usertotalcnt / 10);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		if(page!=1) {
			pageNav.append("		<li>");
			pageNav.append("			<a href=\"board?cpage="+cpage+"&page="+1+"&pagesize=10\" aria-label=\"Previous\">");
			pageNav.append("			<span aria-hidden=\"true\">&laquo;</span></a>");
			pageNav.append("		</li>");
			pageNav.append("		<li>");
			pageNav.append("			<a href=\"board?cpage="+cpage+"&page="+(page-1)+"&pagesize=10\" aria-label=\"Previous\">");
			pageNav.append("			<span aria-hidden=\"true\">&lt;</span></a>");
			pageNav.append("		</li>");
		}
		for(int i = 1; i<pageToTalCnt+1 ; i++){
			if(i==page) 
				pageNav.append("			<li class=\"active\"><a href=\"board?cpage="+cpage+"&page="+(i)+"&pagesize=10\">"+i+"</a></li>");
			else 
				pageNav.append("			<li><a href=\"board?cpage="+cpage+"&page="+(i)+"&pagesize=10\">"+i+"</a></li>");
		}
		if(page!=pageToTalCnt){
			pageNav.append("		<li>");
			pageNav.append("			<a href=\"board?cpage="+cpage+"&page="+(page+1)+"&pagesize=10\" aria-label=\"Next\">");
			pageNav.append("			<span aria-hidden=\"true\">&gt;</span>");
			pageNav.append("			</a></li>");
			pageNav.append("		<li>");
			pageNav.append("			<a href=\"board?cpage="+cpage+"&page="+pageToTalCnt+"&pagesize=10\" aria-label=\"Next\">");
			pageNav.append("			<span aria-hidden=\"true\">&raquo;</span>");
			pageNav.append("			</a></li>");
		}
		pageNav.append("			</ul></nav>");
		
		return pageNav.toString();
	}

	/**
	* Method : getPageTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param cpage
	* @return
	* Method 설명 : 해당 게시판의 모든 게시글 갯수 가져오기
	*/
	@Override
	public int getPageTotalCnt(int cpage) {
		return dao.getBoardTotalCnt(cpage);
	}
	
	
}
