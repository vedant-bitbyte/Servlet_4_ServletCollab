package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// So we increased the age by 5 in this Servlet, but in the Servlet2 this increased age in not sent, but the
		// age in the request obj is sent
		age += 5;
		
		System.out.println("Servlet1 -> Data Validation");
		System.out.println(name + " || " + address + " || " + age);
		
		response.getWriter().write("Data Validation Successfull (Servlet1)<br> ");
		
		
		// Now we have two options, if we used a response.sendRedirext("Servlet2");
		// Then the response goes to the browser and then the browser again sends a new request to the Servlet2.
		// Also the Servlet2 need to have a doGet(), so that the browser can send a get request to Servlet2 through
		// this .sendRedirect()
		// And also because of the new request, this Servlet's request is not send to the Servlet2. Thats why it shows
		// null for the parameters of name and address
		
		/*
		 * Servlet1 -> Data Validation
		 * adfsdf || fasdfasf || 20
		 * Servlet 2 -> Database Logic null || null || null
		 */
		response.sendRedirect("Servlet2");
		
		// We use RequstDispacher to hand the control to the other Servlet at the server side itself.
		// Also in this doPost() is called
//		RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		
		/*
		 * Servlet1 -> Data Validation
		 * adfsdf || fasdfasf || 20
		 * Servlet 2 -> Database Logic adfsdf || fasdfasf || 15
		 */
		
		// Now RequestDispathcer have two methods:
		// 1. .forward(request, response) -> Transfers the request completely to another resource or Servlet,
		//									and the current servlet stops executing.
		// 2. .include(request, response) -> Includes the output of another resource or Servlet in the current response,
		// 									and the current servlet continues executing.
		
		// Also in the URL bar, the name of the Servlet2 does not show, because the control is handed from Servlet1 to
		// Servlet2 at the server side itself.
		// But the Servlet2 can send response directly to browser
		// Because the forward() stops executing the current Servlet, so the response of this Servlet in not included
		// to the next Servlet. The Servlet2's response overrides Servlet1's response.
//		rd.forward(request, response);
		
		// So to include this Servlet1's response to the Servlet2's response, we use the include()
//		rd.include(request, response);
		
	}

}
