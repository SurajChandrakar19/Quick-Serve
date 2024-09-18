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

@WebServlet("/orderHistory")
@SuppressWarnings("serial")
public class OderHistoryServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}
