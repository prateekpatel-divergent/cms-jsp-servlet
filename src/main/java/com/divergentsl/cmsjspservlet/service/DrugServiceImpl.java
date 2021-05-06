package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.dao.DrugDao;
import com.divergentsl.cmsjspservlet.dao.DrugDaoImpl;
import com.divergentsl.cmsjspservlet.entity.Drug;

public class DrugServiceImpl implements DrugService {

	private DrugDao drugDao = new DrugDaoImpl();

	public void add(String name, int rate) {
		Drug drug = new Drug();

		drug.setName(name);
		drug.setRate(rate);

		drugDao.add(drug);
	}

	public boolean remove(int id) {
		Drug drug = this.searchById(id);
		if (drug != null) {
			this.drugDao.remove(id);
			return true;
		}
		return false;
	}

	public Drug searchById(int id) {
		return drugDao.searchById(id);
	}

	public List<Drug> listAll() {
		return this.drugDao.listAll();
	}

}
