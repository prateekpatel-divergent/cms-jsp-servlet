package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Appoinment;

public interface AppoinmentDao {
	
	void add(Appoinment appoinment);
	
	public List<Appoinment> listAll();

	Appoinment searchById(int id);
	
	void remove(int id);
}
