package com.simplilearn.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.UserDao;
import com.simplilearn.dao.UserDaoImpl;
import com.simplilearn.dto.User;


public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String username=request.getParameter("uname");
		String password=request.getParameter("pword");
		User user=new User(firstname,lastname,username,password);
		UserDao dao=new UserDaoImpl();
		  boolean registered=dao.registerUser(user);
		
		if(registered) {
			response.sendRedirect("registersucces.html");
			
		}else {
			response.sendRedirect("registerfailure.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
