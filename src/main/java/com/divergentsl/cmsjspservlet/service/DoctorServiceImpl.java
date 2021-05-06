package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.dao.DoctorDao;
import com.divergentsl.cmsjspservlet.dao.DoctorDaoImpl;
import com.divergentsl.cmsjspservlet.entity.Doctor;


public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao = new DoctorDaoImpl();
	
	public void add(String name, String speciality, String contactno, int fee, String degree) {
		Doctor doctor = new Doctor();

		doctor.setName(name);
		doctor.setSpeciality(speciality);
		doctor.setContactno(contactno);
		doctor.setFee(fee);
		doctor.setDegree(degree);
		
		doctorDao.add(doctor);
	}

	public boolean remove(int id) {
		Doctor doctor = this.searchById(id);
		if (doctor != null) {
			this.doctorDao.remove(id);
			return true;
		}
		return false;
	}

	public Doctor searchById(int id) {
		return doctorDao.searchById(id);
	}

	public List<Doctor> listAll() {
		return this.doctorDao.listAll();
	}

}
