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

import com.divergentsl.cmsjspservlet.entity.Appoinment;
import com.divergentsl.cmsjspservlet.entity.Doctor;
import com.divergentsl.cmsjspservlet.service.AppoinmentService;
import com.divergentsl.cmsjspservlet.service.AppoinmentServiceImpl;
import com.divergentsl.cmsjspservlet.service.DoctorService;
import com.divergentsl.cmsjspservlet.service.DoctorServiceImpl;
import com.divergentsl.cmsjspservlet.service.PatientService;
import com.divergentsl.cmsjspservlet.service.PatientServiceImpl;

@WebServlet("/appoinmentController")
public class AppoinmentController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private final AppoinmentService appoinmentService = new AppoinmentServiceImpl();
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String problem = req.getParameter("problem");
		String appoinmentDate = req.getParameter("appoinmentDate");
		String currentDate = req.getParameter("currentdate");
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		
		
		appoinmentService.add(name, problem, appoinmentDate, currentDate, doctorId);

		List<Appoinment> allAppoinments = appoinmentService.list();
		req.setAttribute("allAppoinments", allAppoinments);
		RequestDispatcher dispatcher = req.getRequestDispatcher("appoinment.jsp");
		dispatcher.forward(req, resp);

	}

//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		int id = Integer.parseInt(req.getParameter("id"));
////		doctorService.remove(doctorId);
//appoinmentService.
//		List<Doctor> allDoctor = doctorService.listAll();
//		req.setAttribute("allDoctor", allDoctor);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("doctor.jsp");
//		dispatcher.forward(req, resp);
//	}
	
}
