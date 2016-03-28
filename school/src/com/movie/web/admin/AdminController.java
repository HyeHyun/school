package com.movie.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

@WebServlet({"/admin/admin_login_form.do", "/admin/admin_login.do", "/admin/admin_form.do", "/member/member_list.do", "/admin/grade_list.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = AdminServiceImpl.getInstance();
		Command command = new Command();
		AdminBean admin = new AdminBean();
		HttpSession session = request.getSession(); // 쉘로우 카피
		String[] str = Seperator.seperator(request);
		
		switch (str[1]) {
		case "admin_login" :
			admin.setId(request.getParameter("id"));
			admin.setPassword(request.getParameter("password"));
			admin = service.getAdmin(admin);

			if (admin.getId() != null) {
				command = CommandFactory.createCommand(str[0], "admin_form");
				session.setAttribute("admin", admin); // session 영역 (BOM)
			} else {
				command = CommandFactory.createCommand(str[0], "admin_login_form");
			}			
			break;
			
		case "admin_form" : 
			request.setAttribute("list", service.getMemberList());
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
			
		case "member_list" :
			request.setAttribute("list", service.getMemberList());
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
			
		case "grade_list" :
			request.setAttribute("list", service.getGradeList());
			command = CommandFactory.createCommand(str[0], str[1]);
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		
		DispatcherServlet.dispatcher(request, response, command);
	}
}
