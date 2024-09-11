package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.RestaurantsDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/restaurants")
@SuppressWarnings("serial")
public class RestaurantsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("restaurants");
		RestaurantsDAOImpl restaurantsDAOImpl = new RestaurantsDAOImpl();
		HttpSession session = req.getSession();
		session.setAttribute("allRestaurants",  restaurantsDAOImpl.fetchAllRastaurants());
		req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
//		resp.sendRedirect("restaurants.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
