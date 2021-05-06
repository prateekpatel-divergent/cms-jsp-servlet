package com.divergentsl.cmsjspservlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.divergentsl.cmsjspservlet.entity.Doctor;
import com.divergentsl.cmsjspservlet.service.DoctorService;
import com.divergentsl.cmsjspservlet.service.DoctorServiceImpl;


@WebServlet("/doctorController")
public class DoctorController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private final DoctorService doctorService = new DoctorServiceImpl();
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String doctorName = req.getParameter("name");
		String doctorSpeciality = req.getParameter("speciality");
		String doctorContactNo = req.getParameter("contactno");
		int doctorFee = Integer.parseInt(req.getParameter("fee"));
		String doctorDegree = req.getParameter("degree");
		
		doctorService.add(doctorName, doctorSpeciality, doctorContactNo, doctorFee, doctorDegree);

		List<Doctor> allDoctor = doctorService.listAll();
		req.setAttribute("allDoctor", allDoctor);
		RequestDispatcher dispatcher = req.getRequestDispatcher("doctor.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int doctorId = Integer.parseInt(req.getParameter("id"));
		doctorService.remove(doctorId);

		List<Doctor> allDoctor = doctorService.listAll();
		req.setAttribute("allDoctor", allDoctor);
		RequestDispatcher dispatcher = req.getRequestDispatcher("doctor.jsp");
		dispatcher.forward(req, resp);
	}
}
