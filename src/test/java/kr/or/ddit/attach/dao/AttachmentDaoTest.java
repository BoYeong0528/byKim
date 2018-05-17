/**
 * 
 */
package kr.or.ddit.attach.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoInf;
import kr.or.ddit.attachment.model.AttachmentVO;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * AttachmentDaoTest.java
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
public class AttachmentDaoTest {

	@Test
	public void getBoardAttachTest() {
		/***Given***/
		AttachmentDaoInf service = new AttachmentDao();

		/***When***/
		List<AttachmentVO> list = service.getBoardAttach(102);

		/***Then***/
		assertNotNull(list);
		assertEquals(2, list.size());

	}

}
