package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Patient;


public interface PatientDao {
	
	void add(Patient patient);

	public List<Patient> listAll();
	
	void remove(int id);
	
	void update(Patient patient);

	Patient searchById(int id);
}
