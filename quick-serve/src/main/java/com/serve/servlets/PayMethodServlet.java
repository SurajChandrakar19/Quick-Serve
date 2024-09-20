package com.serve.servlets;

import java.io.IOException;
import java.util.List;

import com.serve.models.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
@SuppressWarnings("serial")
public class PayMethodServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<CartItem> carts = (List<CartItem>)session.getAttribute("cartItems");
		if(carts == null) {
			resp.sendRedirect("restaurants");
		}else {
			resp.sendRedirect("pay.jsp");
		}
	}
}
