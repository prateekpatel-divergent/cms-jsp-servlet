package com.divergentsl.cmsjspservlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.cmsjspservlet.entity.Drug;
import com.divergentsl.cmsjspservlet.utility.EntityManagerUtility;


public class DrugDaoImpl implements DrugDao{
	
	public void add(Drug drug) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(drug);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Drug drug = entityManager.find(Drug.class, id);
		if (drug != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(drug);
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}

	public List<Drug> listAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Drug> query = entityManager.createQuery("Select e from Drug e", Drug.class);
		List<Drug> drugs = query.getResultList();
		entityManager.close();
		return drugs;
	}

	public void update(Drug drug) {
//		em.persist(drug);
	}

	public Drug searchById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Drug drug = entityManager.find(Drug.class, id);
		entityManager.close();
		return drug;
	}
}
