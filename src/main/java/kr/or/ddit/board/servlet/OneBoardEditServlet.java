package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class OneBoardEditServlet
 */
@WebServlet("/oneBoardEdit")
public class OneBoardEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service;
    public OneBoardEditServlet() {
        super();
        service = new BoardService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yn = request.getParameter("yn");
		int seq = Integer.parseInt( request.getParameter("pbd_seq") );
		
		if(yn.equals("modify")){	//게시글 수정인 경우
			BoardVO vo = service.getOneBoard(seq);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/user/boardReWrite.jsp").forward(request, response);
			
		} else if (yn.equals("delete")){	//게시글 삭제인 경우
			int cnt = service.updateYNvalue(seq);
			request.getRequestDispatcher("/board").forward(request, response);
			
		} else {	//다른 루트인 경우 
			request.getRequestDispatcher("/boardList").forward(request, response);
		}
		
		
	}

}
