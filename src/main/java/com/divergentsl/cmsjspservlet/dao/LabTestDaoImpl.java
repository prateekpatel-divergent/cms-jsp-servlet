package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.cmsjspservlet.entity.LabTest;
import com.divergentsl.cmsjspservlet.utility.EntityManagerUtility;

public class LabTestDaoImpl implements LabTestDao{

	public void add(LabTest labTest) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(labTest);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<LabTest> listAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<LabTest> query = entityManager.createQuery("Select e from LabTest e", LabTest.class);
		List<LabTest> labTests = query.getResultList();
		entityManager.close();
		return labTests;
	}

	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		LabTest labTest = entityManager.find(LabTest.class, id);
		if (labTest != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(labTest);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	public void update(LabTest labTest) {
		
	}

	public LabTest searchById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		LabTest labTest = entityManager.find(LabTest.class, id);
		entityManager.close();
		return labTest;
	}

}
