package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;

public class Seperator {
	public static String[] seperator(HttpServletRequest request) {
		String[] arr = new String[2];
		
		String path = request.getServletPath();
		String temp = path.split("/")[2];
		
		arr[0] = path.split("/")[1]; // directory
		arr[1] = temp.substring(0, temp.indexOf(".")); // action
		
		return arr;
	}
}
