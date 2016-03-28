package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

@WebServlet({"/grade/my_grade.do", "/grade/grade_list.do"})
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		String[] str = Seperator.seperator(request);
		
		switch (str[1]) {
		case "my_grade":
			command = CommandFactory.createCommand(str[0], "my_grade");
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			break;
			
		case "grade_list" :
			request.setAttribute("list", service.getList());
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		
		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		
		DispatcherServlet.dispatcher(request, response, command);
	}
}
