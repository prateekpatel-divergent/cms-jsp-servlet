package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.entity.Drug;

public interface DrugService {

	public void add(String name, int rate);

	public boolean remove(int id);

	public Drug searchById(int id);
	
	public List<Drug> listAll();
}
