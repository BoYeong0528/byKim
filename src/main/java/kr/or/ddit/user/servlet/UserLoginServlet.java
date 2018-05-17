package kr.or.ddit.user.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserServiceInf service;
    public UserLoginServlet() {
        super();
        service = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		
		UserVO vo = new UserVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		int cnt = service.getUserJoined(vo);
		
		request.getSession().setAttribute("userId", vo.getMem_id());
		
		if(cnt>0){
//			if(vo.getMem_id().equals("admin")){		//관리자로 로그인한 경우
				String path ="<li><a href='"+request.getContextPath()+"/adminboard'>게시판 관리</a></li>";
				request.getSession().setAttribute("path", path);
//			} 
				request.getRequestDispatcher("/boardList").forward(request, response);
		}
		else response.sendRedirect(request.getContextPath()+"/user/login.jsp");	//로그인에 실패한 경우
	}

}
