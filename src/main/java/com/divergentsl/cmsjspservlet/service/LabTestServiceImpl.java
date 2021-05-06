package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.dao.LabTestDao;
import com.divergentsl.cmsjspservlet.dao.LabTestDaoImpl;
import com.divergentsl.cmsjspservlet.entity.LabTest;

public class LabTestServiceImpl implements LabTestService{
	
	private LabTestDao labTestDao = new LabTestDaoImpl();
	
	public void add(String name, int rate, int patientid) {
		LabTest labTest = new LabTest();

		labTest.setTest(name);
		labTest.setRate(rate);
		labTest.setPid(patientid);
		
		labTestDao.add(labTest);
	}

	public boolean remove(int id) {
		LabTest labTest = this.searchById(id);
		if (labTest != null) {
			this.labTestDao.remove(id);
			return true;
		}
		return false;
	}

	public LabTest searchById(int id) {
		return labTestDao.searchById(id);
	}

	public List<LabTest> listAll() {
		return this.labTestDao.listAll();
	}
}
