package kr.or.ddit.reply.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyServiceInf service;
    
    public ReplyServlet() {
        super();
        service=new ReplyService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ReplyVO vo = new ReplyVO();
		vo.setRp_bd_seq(Integer.parseInt( request.getParameter("pbd_seq")));
		vo.setRp_mem_id((String)request.getSession().getAttribute("userId"));
		vo.setRp_content(request.getParameter("rp_content"));
		
		int cnt = service.insertReply(vo);
		
		request.setAttribute("bd_seq", Integer.parseInt( request.getParameter("pbd_seq")));
		request.getRequestDispatcher("/oneBoard").forward(request, response);
		
	}

}
