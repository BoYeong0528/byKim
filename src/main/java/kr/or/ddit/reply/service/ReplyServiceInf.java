/**
 * 
 */
package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVO;

/**
 * ReplyServiceInf.java
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
public interface ReplyServiceInf {

	/**
	* Method : getOneBoardAllReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 게시글의 댓글 가져오기
	*/
	public List<ReplyVO> getOneBoardAllReply(int bd_seq);
	
	/**
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 댓글 등록하기
	*/
	public int insertReply(ReplyVO vo);
	
	/**
	* Method : updateReplyYN
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param rp_seq
	* @return
	* Method 설명 : 댓글 삭제하기
	*/
	public int updateReplyYN(int rp_seq);
}
