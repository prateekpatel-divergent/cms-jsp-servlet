package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.LabTest;

public interface LabTestService {
	
	public void add(String name, int rate, int patientid);

	public boolean remove(int id);

	public LabTest searchById(int id);
	
	public List<LabTest> listAll();
}
