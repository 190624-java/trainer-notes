package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	/*
	 * Common interview question: What is the signature of the doPost method?
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello!");
		
		String word = req.getParameter("word");
		
		//server-side rendering (very ugly) 
		PrintWriter out = resp.getWriter();
		//write html directly to http response body
		out.println("<html><body>");
		out.println("<p>Your word is: " + word + "</p>");
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String word = req.getParameter("word");
		//System.out.println("in doGet");
		//store a variable in the request
		//req.setAttribute("someword", word);
		
		//getting servlet config param
		getServletConfig().getInitParameter("someValue");
		
		
		//forward the request. (happens on serverside)
		/*
		 * Forwards
		 * 		Happen on the server
		 * 		End user isn't aware
		 * 		Client sends one request, gets back one response.
		 * 		URL doesn't change
		 */
		//req.getRequestDispatcher("/Hello.jsp").forward(req, resp);
		
		req.getRequestDispatcher("/Hello.html").forward(req, resp);
		
	}
	
}
