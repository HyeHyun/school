package com.movie.web.member;

import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("[메뉴] 1.회원가입 2.로그인 3.내정보보기 4.내정보수정 5.탈퇴 0.종료 ");
			switch (scanner.nextInt()) {
			case 1:
				System.out.print("아이디, 비밀번호, 이름, 주소, 생년월일을 입력하세요 ");
				service.join(new MemberBean(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt()));
				break;
			case 2:
				System.out.print("아이디와 비밀번호를 입력하세요 ");
				System.out.println(service.login(scanner.next(), scanner.next()));
				break;
			case 3:
				System.out.print("조회하려는 회원의 아이디를 입력하세요 ");
				System.out.println(service.detail(scanner.next())); // service.detail(scanner.next()).toString()
				break;
			case 4:
				System.out.print("수정하려는 회원의 아이디, 비밀번호, 주소를 입력하세요 ");
				String id = scanner.next();
				String name = service.detail(id).getName();
				int birth = service.detail(id).getBirth();
				System.out.println(service.update(new MemberBean(id, scanner.next(), name, scanner.next(), birth)));
				break;
			case 5:
				System.out.print("삭제하려는 회원의 아이디를 입력하세요 ");
				System.out.println(service.remove(scanner.next()));
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
