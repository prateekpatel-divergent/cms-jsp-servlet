package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Patient;


public interface PatientService {

	public void add(String name, int age, int weight, String gender, int contactno, String address);

	public boolean remove(int id);

	public Patient searchById(int id);
	
	public List<Patient> listAll();
}
