package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardReWriteServlet
 */
@WebServlet("/boardReWrite")
public class BoardReWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service;
    public BoardReWriteServlet() {
        super();
        service= new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardVO vo = new BoardVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		int cnt = service.updateReWrite(vo);
		request.setAttribute("bd_seq", request.getParameter("bd_seq"));
		request.getRequestDispatcher("/oneBoard").forward(request, response);
	}

}
