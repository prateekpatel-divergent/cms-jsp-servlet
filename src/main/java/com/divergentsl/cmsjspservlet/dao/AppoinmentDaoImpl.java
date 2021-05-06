package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.cmsjspservlet.entity.Appoinment;
import com.divergentsl.cmsjspservlet.utility.EntityManagerUtility;


public class AppoinmentDaoImpl implements AppoinmentDao {


	public void add(Appoinment appoinment) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(appoinment);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Appoinment> listAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Appoinment> query = entityManager.createQuery("Select e from Appoinment e", Appoinment.class);
		List<Appoinment> appoinments = query.getResultList();
		entityManager.close();
		return appoinments;
	}

	public Appoinment searchById(int id) {
		return null;
	}

	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Appoinment appoinment = entityManager.find(Appoinment.class, id);
		if (appoinment != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(appoinment);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
}
