package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Drug;


public interface DrugDao {
	
	void add(Drug drug);

	public List<Drug> listAll();
	
	void remove(int id);
	
	void update(Drug drug);

	Drug searchById(int id);
}
