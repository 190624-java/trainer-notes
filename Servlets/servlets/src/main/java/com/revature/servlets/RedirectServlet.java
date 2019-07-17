package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/app/redirect")
public class RedirectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//request.setAttribute("name", name);
		
		//set session attributes
		request.getSession().setAttribute("name", name);
		
		//redirect the client (server tells the client to go to a page)
		/*
		 * Redirect
		 * 		Client is aware
		 * 		Can be bookmarked
		 * 		Client makes one request, gets back 2 responses
		 * 		request variables go out of scope
		 * 		Change the URL
		 * 		Session/application scoped variables are accessible
		 */
		response.sendRedirect("/servlets/Hello.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
