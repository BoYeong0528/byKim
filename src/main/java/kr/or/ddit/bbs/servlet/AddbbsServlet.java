package kr.or.ddit.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bbs.model.BbsVO;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.BbsServiceInf;

/**
 * Servlet implementation class AddbbsServlet
 */
@WebServlet("/addbbs")
public class AddbbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BbsServiceInf service;   
	
    public AddbbsServlet() {
        super();
        service = new BbsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("bbs_name");
		String id = (String) request.getSession().getAttribute("userId");
		
		BbsVO vo = new BbsVO();
		vo.setBbs_name(name);
		vo.setBbs_mem_id(id);
		
		int cnt = service.insertBbs(vo);
		
		if(cnt > 0) request.getRequestDispatcher("/boardList").forward(request, response);
		else request.getRequestDispatcher("/user/addbbs.jsp").forward(request, response);
	}


}
