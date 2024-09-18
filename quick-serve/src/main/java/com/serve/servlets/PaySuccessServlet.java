package com.serve.servlets;

import java.io.IOException;
import java.util.List;

import com.serve.dao.impl.CartDAOImpl;
import com.serve.models.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/paySuccess")
@SuppressWarnings("serial")
public class PaySuccessServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		List<CartItem> carts = (List<CartItem>) session.getAttribute("cartItems");
		if(carts == null) {
			resp.sendRedirect("restaurants");
		}else {
			String payMethod = req.getParameter("payment");
			
			CartDAOImpl cartDAOImpl = new CartDAOImpl();
			
			for(CartItem menu : carts ){
				menu.setStatus("ordered");
				menu.setPayMethod(payMethod);
				cartDAOImpl.updateCart(menu);
			}
			
			session.removeAttribute("cartItems");
	
			resp.sendRedirect("payment_success.jsp");
		}
	}
}
