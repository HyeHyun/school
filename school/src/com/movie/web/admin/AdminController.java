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

@WebServlet({"/admin/login_form.do", "/admin/login.do", "/admin/admin_form.do", "/admin/logout.do"})
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
		case "login" :
			admin.setId(request.getParameter("id"));
			admin.setPassword(request.getParameter("password"));
			AdminBean temp = service.getAdmin(admin);

			if (temp.getId() != null) {
				command = CommandFactory.createCommand(str[0], "admin_form");
				session.setAttribute("admin", temp); // session 영역 (BOM)
			} else {
				command = CommandFactory.createCommand(str[0], "login_form");
			}			
			break;
			
		case "logout":
			session.invalidate();
			command = CommandFactory.createCommand(str[0], "login_form");
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		
		DispatcherServlet.dispatcher(request, response, command);
	}
}
