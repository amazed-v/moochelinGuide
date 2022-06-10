package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Follow;

@WebServlet("/member/myPage/follow")
public class MyPageFollowController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int mode = Integer.parseInt(req.getParameter("mode"));
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));

			List<Follow> fList = new MemberService().follow(mode, memberNo);
			
			req.setAttribute("fList", fList);
		    
		    String path = null;
		    if(mode==1) {
		    	System.out.println("팔로워목록"+fList);
		    	path = "/WEB-INF/views/member/myPage_follower.jsp";
		    }else {
		    	System.out.println("팔로잉목록"+fList);
		    	path = "/WEB-INF/views/member/myPage_following.jsp";
		    }

		    req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
	}

}
