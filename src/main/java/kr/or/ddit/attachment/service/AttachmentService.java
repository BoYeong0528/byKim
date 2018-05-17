/**
 * 
 */
package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoInf;
import kr.or.ddit.attachment.model.AttachmentVO;

/**
 * AttachmentService.java
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
public class AttachmentService implements AttachmentServiceInf{
	
	private AttachmentDaoInf dao;
	
	public AttachmentService() {
		dao = new AttachmentDao();
	}

	/**
	* Method : insertAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertAttach(AttachmentVO vo) {
		return dao.insertAttach(vo);
	}

	/**
	* Method : getBoardAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bd_seq
	* @return
	* Method 설명 : 해당 글의 첨부파일 가져오기
	*/
	@Override
	public List<AttachmentVO> getBoardAttach(int bd_seq) {
		return dao.getBoardAttach(bd_seq);
	}

}
