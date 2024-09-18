package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.CartDAOImpl;
import com.serve.dao.impl.MenuDAOImpl;
import com.serve.models.MenuModel;
import com.serve.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
@SuppressWarnings("serial")
public class AddToCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user = (UserModel)session.getAttribute("loginUser");
		if(user == null) {
			resp.sendRedirect("login.jsp");
		}else {
			int iId = Integer.parseInt(req.getParameter("iId"));
			int rId = Integer.parseInt(req.getParameter("rId"));
			
			MenuDAOImpl item = new MenuDAOImpl();
			MenuModel menu = item.fetchMenu(iId);
			
			CartDAOImpl cartDAOImpl = new CartDAOImpl();
			
			if(cartDAOImpl.addFoodOnCart(user.getId(), rId, menu, 1, false, "nothing", menu.isSpicy())) {
				System.out.println("add item to car successfully");
			}else {
				System.out.println("item not add into car addToCartServlet Problem");
			}
			resp.sendRedirect("addToCart.jsp");
		}
	}
}
