package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attachment.model.AttachmentVO;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class OneBoardServlet
 */
@WebServlet("/oneBoard")
public class OneBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service;
    private ReplyServiceInf rpservice;
    private AttachmentServiceInf attservice;
    
    public OneBoardServlet() {
        super();
        service = new BoardService();
        rpservice = new ReplyService();
        attservice = new AttachmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bd_seq = 0;
		if(request.getParameter("bd_seq")==null) bd_seq= (int)request.getAttribute("bd_seq");
		else bd_seq = Integer.parseInt( request.getParameter("bd_seq") );
		
		BoardVO vo = service.getOneBoard(bd_seq);
		List<ReplyVO> list = rpservice.getOneBoardAllReply(bd_seq);
		List<AttachmentVO> atlist = attservice.getBoardAttach(bd_seq);
		if(vo.getBd_del_yn().equals("Y")){
			request.setAttribute("attlist", atlist);
			request.setAttribute("vo", vo);
			request.setAttribute("rplist", list);
			request.getRequestDispatcher("/user/boardView.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/user/boardContent.jsp").forward(request, response);
		}
	}

}
