/**
 * 
 */
package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

/**
 * BoardDaoInf.java
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
public interface BoardDaoInf {

	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 게시글의 리스트를 가져온다
	*/
	public List<BoardVO> getAllBoard(int page, int pageSize, int cpage);	
	
	/**
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체 건수 조회
	*/
	public int getBoardTotalCnt(int cpage);
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 업로드
	*/
	public int insertBoard(BoardVO vo);
	
	/**
	* Method : getOneBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당하는 게시글의 상세정보 가져오기
	*/
	public BoardVO getOneBoard(int bd_seq);
	
	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 수정하기
	*/
	public int updateReWrite(BoardVO vo);
	
	/**
	* Method : updateReWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시글 삭제여부 수정하기
	*/
	public int updateYNvalue(int bd_seq);
	
	/**
	* Method : getPageTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param cpage
	* @return
	* Method 설명 : 해당 게시판의 게시글 갯수 가져오기
	*/
	public int getPageTotalCnt(int cpage);
}
