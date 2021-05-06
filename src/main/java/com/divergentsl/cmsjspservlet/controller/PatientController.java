package com.divergentsl.cmsjspservlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divergentsl.cmsjspservlet.entity.Patient;
import com.divergentsl.cmsjspservlet.service.PatientService;
import com.divergentsl.cmsjspservlet.service.PatientServiceImpl;

@WebServlet("/patientController")
public class PatientController {
	
	private static final long serialVersionUID = 1L;

	private final PatientService patientService = new PatientServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String patientName = req.getParameter("patient_name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("patient_age"));
		int weight = Integer.parseInt(req.getParameter("patient_weight"));
		int contactNumber = Integer.parseInt(req.getParameter("contact_number"));
		String address = req.getParameter("address");
		
		patientService.add(patientName, age, weight, gender, contactNumber, address);
		
		List<Patient> allPatient = patientService.listAll();
		req.setAttribute("allPatient", allPatient);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		patientService.remove(id);

		List<Patient> allPatient = patientService.listAll();
		req.setAttribute("allPatient", allPatient);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);
	}
}
