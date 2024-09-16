package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.CartDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCart")
@SuppressWarnings("serial")
public class UpdateCartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int cartItemId = Integer.parseInt(req.getParameter("cart_item_id"));
			CartDAOImpl cartDAOImpl = new CartDAOImpl();
			if(cartItemId >= 1) {
				cartDAOImpl.updateCart(quantity, cartItemId);
			}				
			resp.sendRedirect("addToCart.jsp");
	}
}
