package com.serve.servlets;

import java.io.IOException;

import com.serve.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cLogin")
@SuppressWarnings("serial")
public class CheckLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if((UserModel)session.getAttribute("loginUser") != null) {
			resp.sendRedirect("index.jsp");
		}else {
		
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			if(email != null && password != null) {
				
				session.setAttribute("user", (new UserModel(email, password)));
				req.getRequestDispatcher("login").forward(req, resp);
			}
		}
	}
}
	
