package com.movie.web.grade;

import java.util.*;

public class GradeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();
		
		while (true) {
			System.out.print("[메뉴] 1.등록 2.수정 3.삭제 4.조회(전체) 5.조회(이름) 6.조회(학번) 7.회원수 0.종료 ");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.print("학번, 이름, 자바, SQL, JSP, 스프링 점수를 입력하세요 ");	
				System.out.println(service.input(new GradeBean(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt())));
				break;
			case 2:
				System.out.print("수정하려는 성적표의 학번, 자바, SQL, JSP, 스프링 점수를 입력하세요 ");
				break;
			case 3:
				System.out.print("학번을 입력하세요 ");
				System.out.println(service.delete(scanner.nextInt()));
				break;
			case 4:
				System.out.println(service.getList());
				break;
			case 5:
				System.out.print("이름을 입력하세요 ");
				System.out.println(service.getGradesByName(scanner.next()));
				break;
			case 6:
				System.out.print("학번을 입력하세요 ");
				break;
			case 7:
				System.out.println(service.getCount());
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
		}
	}
}
