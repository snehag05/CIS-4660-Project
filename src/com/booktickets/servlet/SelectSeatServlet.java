package com.booktickets.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booktickets.DAO.DBConnection;

@WebServlet ("/SelectSeat")
public class SelectSeatServlet extends HttpServlet{
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
		//System.out.println("Servlet Called");
		HttpSession session = request.getSession();
		String [] seats = request.getParameterValues("selected_seats");
		for(int i= 0; i<seats.length;i++)
			System.out.println(seats[i]);
		DBConnection db=new DBConnection();
		db.transaction(session, seats);
		//response.sendRedirect("/");
	}
	
}
