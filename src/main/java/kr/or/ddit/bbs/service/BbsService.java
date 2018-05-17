/**
 * 
 */
package kr.or.ddit.bbs.service;

import java.util.List;

import kr.or.ddit.bbs.dao.BbsDao;
import kr.or.ddit.bbs.dao.BbsDaoInf;
import kr.or.ddit.bbs.model.BbsVO;

/**
 * BbsService.java
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
public class BbsService implements BbsServiceInf{
	
	private BbsDaoInf dao;
	
	public BbsService(){
		dao = new BbsDao();
	}

	/**
	* Method : getBbsList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 : 
	*/
	@Override
	public List<BbsVO> getBbsList() {
		return dao.getBbsList();
	}

	/**
	* Method : insertBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 게시판 추가하기
	*/
	@Override
	public int insertBbs(BbsVO vo) {
		return dao.insertBbs(vo);
	}

	/**
	* Method : updateBbs
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @param bbs_seq
	* @return
	* Method 설명 :
	*/
	@Override
	public int updateBbs(int bbs_seq) {
		return dao.updateBbs(bbs_seq);
	}

	/**
	* Method : getAllBbsList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<BbsVO> getAllBbsList() {
		return dao.getAllBbsList();
	}

}
