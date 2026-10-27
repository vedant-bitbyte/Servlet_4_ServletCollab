package com.controller1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// ternary operator to get age as 0 if the String age is null
		int age = request.getParameter("age") != null ? Integer.parseInt(request.getParameter("age")) : 0;
		
		System.out.println("Servlet 2 -> Database Logic " + name + " || " + address + " || " + age);
		
		response.getWriter().write("Database Logic applied (Servlet2)");
		
	}

}
