package com.divergentsl.cmsjspservlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divergentsl.cmsjspservlet.entity.Doctor;
import com.divergentsl.cmsjspservlet.entity.LabTest;
import com.divergentsl.cmsjspservlet.service.DoctorService;
import com.divergentsl.cmsjspservlet.service.DoctorServiceImpl;
import com.divergentsl.cmsjspservlet.service.LabTestService;
import com.divergentsl.cmsjspservlet.service.LabTestServiceImpl;

@WebServlet("/labtestController")
public class LabTestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private final LabTestService labTestService = new LabTestServiceImpl();
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		int rate = Integer.parseInt(req.getParameter("rate"));
		int patientid = Integer.parseInt(req.getParameter("id"));

		labTestService.add(name, rate, patientid);

		List<LabTest> allLabTest = labTestService.listAll();
		req.setAttribute("allLabTest", allLabTest);
		RequestDispatcher dispatcher = req.getRequestDispatcher("labtest.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		labTestService.remove(id);

		List<LabTest> allLabTest = labTestService.listAll();
		req.setAttribute("allLabTest", allLabTest);
		RequestDispatcher dispatcher = req.getRequestDispatcher("labtest.jsp");
		dispatcher.forward(req, resp);

	}
}
