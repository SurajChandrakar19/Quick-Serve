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
@WebServlet("/profile")
public class ProfileUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel adminUser = (UserModel)req.getSession().getAttribute("loginUser");
		if(adminUser == null) {
			resp.sendRedirect("login.jsp");
		}else {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			
			
			if(name != null && email != null && phone.length() == 10 && password != null) {
				
				UserModel user = new UserModel(adminUser.getId(),name,email,password,phone);
				UserDAOImpl userDAOImpl = new UserDAOImpl();
				
				System.out.println(user.getfName() + user.getEmail() + user.getPhonenumber() + user.getPassword());
				
				if(userDAOImpl.update(user)) {
					resp.sendRedirect("logout");
				}else {
					System.out.println("user update faild");
				}
			}
		}
	}
}
