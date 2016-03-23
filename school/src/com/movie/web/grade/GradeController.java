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
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

@WebServlet({"/grade/my_grade.do"})
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();
	
	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		String path = request.getServletPath();
		String temp = path.split("/")[2];
		
		String directory = path.split("/")[1];
		String action = temp.substring(0, temp.indexOf("."));
		
		switch (action) {
		case "my_grade":
			command = CommandFactory.createCommand(directory, "my_grade");
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			break;
		
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
