package com.movie.web.global;

public class Command {
	private String directory, action, view;

	public Command() {}
	
	public Command(String directory, String action) {
		this.directory = directory;
		this.action = action;
		this.view = Constants.VIEWS + "/" + directory + "/" + action + ".jsp";
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
}
/**
 * URL : http://localhost:9000/school/member/login_form.do
 * 컨텍스트패스 : http://localhost:9000/school
 * WebContents : /
 * URI(겟방식) : member/login_form.do?id=hong&password=1
 * URI(포스트방식) : member/login.do
 * 쿼리스트림 구분자 : ?
 * 파라미터 구분자 : &
 * 쿼리스트림 : id=hong&password=1
 * 
 * URI 는 프로젝트 내부에서 유일한 값(ID) 이어야 하며,
 * 이 URI 를 분해해서 서블릿에게 명령을 내리는 구조로 이루어진다.
 * */

/**
 * member/login_form.do?id=hong&password=1
 * 
 * member : forder >> directory
 * login_form
 * do
 * id=hong
 * password=1
 */