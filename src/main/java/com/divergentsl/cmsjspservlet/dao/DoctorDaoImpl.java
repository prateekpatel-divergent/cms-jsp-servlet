package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.cmsjspservlet.entity.Doctor;
import com.divergentsl.cmsjspservlet.utility.EntityManagerUtility;


public class DoctorDaoImpl implements DoctorDao {

	
	public void add(Doctor doctor) {
		
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(doctor);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<Doctor> listAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Doctor> query = entityManager.createQuery("Select e from Doctor e", Doctor.class);
		List<Doctor> doctors = query.getResultList();
		entityManager.close();
		return doctors;
	}

	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class, id);
		if (doctor != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(doctor);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

//	public void update(Doctor doctor) {
//		em.persist(doctor);
//	}

	public Doctor searchById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class, id);
		entityManager.close();
		return doctor;
	}
}
