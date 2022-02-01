package com.mouritech.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mouritech.jpa.entity.Student;



public class Main {

		public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Student st = new Student(123L, "Rama", "Krishna", "6757567567");
			entityManager.persist(st);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();


	}

}
