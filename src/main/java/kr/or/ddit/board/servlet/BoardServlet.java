package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service;
	
    public BoardServlet() {
        super();
        service = new BoardService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer cpage = Integer.parseInt( request.getParameter("cpage"));
    	Map<String, Object> res =null;
    	if(request.getParameter("page")==null){
    		res = service.getAllBoard(1, 10, cpage);
    	} else {
	    	int page =Integer.parseInt( request.getParameter("page"));
	    	int pagesize =Integer.parseInt( request.getParameter("pagesize"));
	    	res = service.getAllBoard(page, pagesize, cpage);
    	}
    	String name = request.getParameter("name");
    	if(name!=null){
    		request.getSession().setAttribute("bname", name);
    	}
    	if(cpage!=null){
    		request.getSession().setAttribute("cpage", cpage);
    	}
    	
    	
    	request.setAttribute("pageNav", res.get("pageNav"));
    	request.setAttribute("bdlist", res.get("pageList"));
    	request.setAttribute("name", name);
    	request.getRequestDispatcher("/user/mainBoard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }
}
