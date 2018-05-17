/**
 * 
 */
package kr.or.ddit.bbs.service;

import java.util.List;

import kr.or.ddit.bbs.model.BbsVO;

/**
 * BbsServiceInf.java
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
public interface BbsServiceInf {

	/**
	* Method : getBbsList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트 불러오기 활성화만
	*/
	public List<BbsVO> getBbsList();
	
	/**
	 * Method : getBbsList
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.BoYeong"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 리스트 불러오기
	 */
	public List<BbsVO> getAllBbsList();
	
	/**
	* Method : insertBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시판 추가하기
	*/
	public int insertBbs(BbsVO vo);
	
	/**
	* Method : updateBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bbs_seq
	* @return
	* Method 설명 : 게시판 활성화 여부 변경하기
	*/
	public int updateBbs(int bbs_seq);
	
}
