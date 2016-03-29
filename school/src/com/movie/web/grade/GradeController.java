package com.movie.web.grade;

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
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

@WebServlet({"/grade/my_grade.do", "/grade/grade_list.do", "/grade/add_form.do", "/grade/grade_add.do"})
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService service = GradeServiceImpl.getInstance();
		MemberService memberService = MemberServiceImpl.getInstance();
		Command command = new Command();
		String[] str = Seperator.seperator(request);
		GradeBean grade = new GradeBean();
		
		switch (str[1]) {
		case "my_grade":
			command = CommandFactory.createCommand(str[0], "my_grade");
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			break;
			
		case "grade_list" :
			request.setAttribute("list", service.getList());
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		
		case "add_form" :
			request.setAttribute("member", memberService.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
			
		case "grade_add" :
			grade.setId(request.getParameter("id"));
			grade.setJava(Integer.parseInt(request.getParameter("java")));
			grade.setJsp(Integer.parseInt(request.getParameter("jsp")));
			grade.setSql(Integer.parseInt(request.getParameter("sql")));
			grade.setSpring(Integer.parseInt(request.getParameter("spring")));

			if (service.input(grade) == 1) {
				command = CommandFactory.createCommand("admin", "admin_form");
			} else {
				command = CommandFactory.createCommand(str[0], "add_form");
			}
			break;
			
		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		
		DispatcherServlet.dispatcher(request, response, command);
	}
}
