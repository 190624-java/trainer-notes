package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Pet;
import com.revature.services.PetService;

@WebServlet("/app/pet")
public class PetServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("The Pet Servlet is ready...");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Use Jackson to write JSON for us.
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(PetService.getAllPets()));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pet newPet = new Pet(PetService.pets.size() + 1, 
				request.getParameter("name"),
				request.getParameter("type"));
		
		PetService.pets.add(newPet);
		response.setStatus(201);
		response.sendRedirect("/servlets/");
	}

}
