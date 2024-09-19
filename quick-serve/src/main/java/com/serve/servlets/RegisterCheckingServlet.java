package com.serve.servlets;

import java.io.IOException;
import com.serve.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/cRegister")
public class RegisterCheckingServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String number = req.getParameter("phonenumber");
		if(name != null && email != null && password != null && number.length() == 10) {
			
			HttpSession session = req.getSession();
			session.setAttribute("registerUser", new UserModel(name,email, password, number));
			System.out.println("user register checking confirmd");
			req.getRequestDispatcher("/register").forward(req, resp);
			
		}else {
			System.out.println("all reilds important");
		}
	}
}
