package com.booktickets.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booktickets.DAO.DBConnection;
import com.booktickets.pojo.UserDetails;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

	UserDetails user=new UserDetails();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doCommon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		
			
		DBConnection db=new DBConnection();
		db.signUp(user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone());
		response.sendRedirect(".//Login.html");
			
		
	}
}
