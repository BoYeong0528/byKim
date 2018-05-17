package kr.or.ddit.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bbs.model.BbsVO;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.bbs.service.BbsServiceInf;

/**
 * Servlet implementation class AdminboardServlet
 */
@WebServlet("/adminboard")
public class AdminboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BbsServiceInf service;   
	
    public AdminboardServlet() {
        super();
        service = new BbsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BbsVO> list = service.getAllBbsList();		
		request.setAttribute("adminbbslist", list);
		request.getRequestDispatcher("/user/adminboard.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
