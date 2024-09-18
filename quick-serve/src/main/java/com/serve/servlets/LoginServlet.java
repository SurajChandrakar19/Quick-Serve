package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.UserDAOImpl;
import com.serve.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		UserModel userLogin = (UserModel) userDAOImpl.fetch(user);
		if(userLogin != null) {
			resp.sendRedirect("index.jsp");
			session.setAttribute("loginUser", user);
			System.out.println("login user succesfully");
		}else {
			resp.sendRedirect("login.jsp");
			System.out.println("invailid email password");
		}
		
	}
}
