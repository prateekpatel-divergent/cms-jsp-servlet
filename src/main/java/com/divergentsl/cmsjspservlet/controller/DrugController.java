package com.divergentsl.cmsjspservlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.divergentsl.cmsjspservlet.entity.Drug;
import com.divergentsl.cmsjspservlet.service.DrugService;
import com.divergentsl.cmsjspservlet.service.DrugServiceImpl;

@WebServlet("/drugController")
public class DrugController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private final DrugService drugService = new DrugServiceImpl();
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		int rate =Integer.parseInt(req.getParameter("rate"));

		drugService.add(name, rate);

		List<Drug> allDrug = drugService.listAll();
		req.setAttribute("allDrug", allDrug);
		RequestDispatcher dispatcher = req.getRequestDispatcher("drug.jsp");
		dispatcher.forward(req, resp);

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		drugService.remove(id);

		List<Drug> allDrug = drugService.listAll();
		req.setAttribute("allDrug", allDrug);
		RequestDispatcher dispatcher = req.getRequestDispatcher("drug.jsp");
		dispatcher.forward(req, resp);
	}
}
