package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.HeroDAO;
import com.revature.DAO.HeroDAOImplDB;
import com.revature.beans.Hero;

public class HeroServlet extends HttpServlet {

	private HeroDAO dao;

	@Override
	public void init() throws ServletException {
		System.out.println("Hero Servlet Ready To Go!");
		try {
			this.dao = new HeroDAOImplDB();
		} catch (SQLException e) {
			System.out.println("A SQL exception occurred!");
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if (request.getRequestURI().contains("all")) {
				System.out.println("contains all");
				// get heroes from db
				List<Hero> allHeroes = dao.getAllHeroes();
				ObjectMapper mapper = new ObjectMapper();
				response.getWriter().print(mapper.writeValueAsString(allHeroes));
			} else {
				request.getRequestDispatcher("/index.html").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hero newHero = new Hero(request.getParameter("name"), Integer.parseInt(request.getParameter("level")),
				request.getParameter("heroClass"));
		dao.createHero(newHero);
		response.setStatus(201);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void destroy() {
		HeroDAOImplDB dao2 = (HeroDAOImplDB) dao;
		try {
			dao2.getDBConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
