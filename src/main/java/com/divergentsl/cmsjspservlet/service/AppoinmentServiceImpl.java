package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.dao.AppoinmentDao;
import com.divergentsl.cmsjspservlet.dao.AppoinmentDaoImpl;
import com.divergentsl.cmsjspservlet.entity.Appoinment;


public class AppoinmentServiceImpl implements AppoinmentService{

	private AppoinmentDao appoinmentDao = new AppoinmentDaoImpl();
	
	public void add(String name, String problem, String appoinmentDate, String currentDate ,int doctorId){	
	
		Appoinment appoinment = new Appoinment();
		
		appoinment.setPname(name);
		appoinment.setProblem(problem);
		appoinment.setAppoinmentDate(appoinmentDate);
		appoinment.setCurrentDate(currentDate);
		appoinmentDao.add(appoinment);
	}

	public List<Appoinment> list() {
		return this.appoinmentDao.listAll();
	}

	public Appoinment searchById(int id) {
		return appoinmentDao.searchById(id);
	}
}
