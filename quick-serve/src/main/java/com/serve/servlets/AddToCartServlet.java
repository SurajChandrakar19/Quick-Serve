package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.CartDAOImpl;
import com.serve.dao.impl.MenuDAOImpl;
import com.serve.models.MenuModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
@SuppressWarnings("serial")
public class AddToCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println();
		int iId = Integer.parseInt(req.getParameter("iId"));
		int rId = Integer.parseInt(req.getParameter("rId"));
		MenuDAOImpl item = new MenuDAOImpl();
		MenuModel menu = item.fetchMenu(iId);
		
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		cartDAOImpl.addFoodOnCart(1, rId, menu, 1, false, "nothi8ng", menu.isSpicy());
		resp.sendRedirect("addToCart.jsp");
	}
}
