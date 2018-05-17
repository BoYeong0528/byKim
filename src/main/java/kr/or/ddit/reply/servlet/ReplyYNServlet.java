package kr.or.ddit.reply.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplyYNServlet
 */
@WebServlet("/replyYN")
public class ReplyYNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyServiceInf service;
	
    public ReplyYNServlet() {
        super();
        service = new ReplyService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rp_seq = Integer.parseInt( request.getParameter("rp_seq") );
		int bd_seq = Integer.parseInt( request.getParameter("pbd_seq") );
		
		int cnt = service.updateReplyYN(rp_seq);
		
		request.setAttribute("bd_seq", bd_seq);
		request.getRequestDispatcher("/oneBoard").forward(request, response);
	}

}
