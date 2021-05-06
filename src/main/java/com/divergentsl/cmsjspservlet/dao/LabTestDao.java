package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.LabTest;

public interface LabTestDao {

	
	void add(LabTest labTest);

	public List<LabTest> listAll();
	
	void remove(int id);
	
	void update(LabTest labTest);

	LabTest searchById(int id);
}
