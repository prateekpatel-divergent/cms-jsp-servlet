package com.divergentsl.cmsjspservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
@WebServlet("/login")
public class AdminDoctorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		logger.debug("init() called !!!!");
	}

	@Override
	public void destroy() {
		super.destroy();
		logger.debug("destroy() called !!!!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin123") && password.equals("doctor123")) {
			out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
