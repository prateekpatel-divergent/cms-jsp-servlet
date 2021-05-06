package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Appoinment;

public interface AppoinmentService {

	public List<Appoinment> list();
	
	public Appoinment searchById(int id);

	public void add(String name, String problem, String appoinmentDate, String currentDate,int doctorId);
}
