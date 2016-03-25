package com.movie.web.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

@WebServlet({"/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do", 
			"/member/detail.do", "/member/update_form.do", "/member/update.do", "/member/delete.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberServiceImpl.getInstance();
		Command command = new Command();
		String[] str = Seperator.seperator(request);
		MemberBean member = new MemberBean();
		System.out.println("서비스 확인");
		switch (str[1]) {
		
		case "login":
			if (service.login(request.getParameter("id"), request.getParameter("password"))) {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "detail");
			} else {
				command = CommandFactory.createCommand(str[0], "login_form");
			}
			break;
			
		case "detail":
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
			
		case "update_form":
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], "update_form");
			break;
			
		case "delete":
			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				command = CommandFactory.createCommand(str[0], "detail");
			}
			break;
			
		case "join":
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));

			if (service.join(member) == 1) {
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				command = CommandFactory.createCommand(str[0], "join_form");
			}
			
			break;
			
		case "update":
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			
			if (service.update(member) == 1) {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "detail");
			} else {
				command = CommandFactory.createCommand(str[0], "update_form");
			}
			
			break;
		
		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		
		DispatcherServlet.dispatcher(request, response, command);
	}
}
