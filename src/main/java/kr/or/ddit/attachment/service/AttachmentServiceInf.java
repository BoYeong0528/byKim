/**
 * 
 */
package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.model.AttachmentVO;

/**
 * AttachmentServiceInf.java
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
public interface AttachmentServiceInf {
	
	/**
	* Method : insertAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 첨부파일 첨부
	*/
	public int insertAttach(AttachmentVO vo);
	
	/**
	* Method : getBoardAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 글의 모든 첨부파일 가져오기
	*/
	public List<AttachmentVO> getBoardAttach(int bd_seq);
}
