package com.serve.servlets;

import java.io.IOException;

import com.serve.dao.impl.UserDAOImpl;
import com.serve.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		if(userDAOImpl.add((UserModel)req.getSession().getAttribute("registerUser"))) {
			System.out.println("successfully register");
			resp.sendRedirect("login.jsp");
			userDAOImpl = null;
			req.getSession().removeAttribute("registerUser");
		}else {
			System.out.println("not register");
		}
	}

}
