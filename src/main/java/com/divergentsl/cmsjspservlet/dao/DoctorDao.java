package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Doctor;

public interface DoctorDao {
	
	void add(Doctor doctor);

	public List<Doctor> listAll();
	
	void remove(int id);
	
//	void update(Doctor doctor);

	Doctor searchById(int id);
}
