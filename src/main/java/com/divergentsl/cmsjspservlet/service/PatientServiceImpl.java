package com.divergentsl.cmsjspservlet.service;

import java.util.List;

import com.divergentsl.cmsjspservlet.dao.PatientDao;
import com.divergentsl.cmsjspservlet.dao.PatientDaoImpl;
import com.divergentsl.cmsjspservlet.entity.Patient;

public class PatientServiceImpl implements PatientService {

	private PatientDao patientDao = new PatientDaoImpl();

	public void add(String name, int age, int weight, String gender, int contactNumber, String address) {

		Patient patient = new Patient();

		patient.setName(name);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setGender(gender);
		patient.setContactNumber(contactNumber);
		patient.setAddress(address);

		patientDao.add(patient);

	}

	public boolean remove(int id) {
		Patient patient = this.searchById(id);
		if (patient != null) {
			this.patientDao.remove(id);
			return true;
		}
		return false;
	}

	public Patient searchById(int id) {
		return patientDao.searchById(id);
	}

	public List<Patient> listAll() {
		return this.patientDao.listAll();
	}
}
