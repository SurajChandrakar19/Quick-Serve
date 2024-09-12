package com.serve.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.serve.dao.impl.MenuDAOImpl;
import com.serve.models.MenuModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menus")
@SuppressWarnings("serial")
public class MenusServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("hello" + req.getParameter("id"));
//		System.out.println(req.getParameter("name"));
		
		req.getRequestDispatcher("restaurants-menus.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println(req.getParameter("id"));
		
	}
}
