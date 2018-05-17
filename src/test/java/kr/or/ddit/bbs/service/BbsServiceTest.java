/**
 * 
 */
package kr.or.ddit.bbs.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.bbs.model.BbsVO;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.BbsServiceInf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * BbsServiceTest.java
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
public class BbsServiceTest {


	/**
	* Method : getBbsListTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* Method 설명 : 게시판 리스트 불러오기
	*/
	@Test
	public void getBbsListTest() {
		/***Given***/
		BbsServiceInf sevice = new BbsService();

		/***When***/
		List<BbsVO> list = sevice.getBbsList();
		
		/***Then***/
		assertEquals(3, list.size());

	}
	
	/**
	* Method : insertBbsTest
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.BoYeong"
	* 변경이력 :
	* Method 설명 : 게시판 추가 테스트
	*/
	@Test
	public void insertBbsTest(){
		/***Given***/
		BbsServiceInf service = new BbsService();
		BbsVO vo = new BbsVO();
		vo.setBbs_mem_id("admin");
		vo.setBbs_name("큐앤에이");
		
		/***When***/
		int cnt = service.insertBbs(vo);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(1, cnt);

	}

}
