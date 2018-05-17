package kr.or.ddit.board.servlet;

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
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BbsServiceInf service;
    
    public BoardList() {
        super();
        service = new BbsService();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BbsVO> list = service.getBbsList();
		request.getSession().setAttribute("bbsList", list);
		
		request.getRequestDispatcher("/user/main.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
