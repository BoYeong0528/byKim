package kr.or.ddit.board.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attachment.model.AttachmentVO;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/boardWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH="D:\\A_TeachingMaterial\\7.JspSpring\\workspace\\byKim\\src\\main\\webapp\\images";
	private BoardServiceInf service;
	private AttachmentServiceInf attservice;
	
    public BoardWriteServlet() {
        super();
        service = new BoardService();
        attservice = new AttachmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardVO vo = new BoardVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		vo.setBd_reg_id((String)request.getSession().getAttribute("userId"));
		vo.setBd_bbs_seq((int) request.getSession().getAttribute("cpage"));
		
		if(request.getParameter("pbd_seq")==null || request.getParameter("pbd_seq").equals("")){
			vo.setPbd_seq(null);
		} else {
			vo.setPbd_seq(Integer.parseInt(request.getParameter("pbd_seq")));
		}
		
		int bd_seq = service.insertBoard(vo);
		
		Collection<Part> parts = request.getParts();
		List<String> filename = new ArrayList<String>();
		
		AttachmentVO att = new AttachmentVO();
		att.setAtt_bd_seq(bd_seq);
		int size=0;
		for (Part part : parts) {
			if(part.getName().equals("att_path") && part.getSize()>0){
				size++;
				String rand = UUID.randomUUID().toString();
				att.setAtt_path(rand);
				String filePath = UPLOAD_PATH+File.separator+rand;
				filename.add(rand);
				part.write(filePath);
				part.delete();
				int cnt = attservice.insertAttach(att);
			}
		}
		List<AttachmentVO> list = attservice.getBoardAttach(bd_seq);
		
		request.setAttribute("attlist", list);
		request.setAttribute("bd_seq", bd_seq);
		if(bd_seq>0) request.getRequestDispatcher("/oneBoard").forward(request, response);
	}

}
