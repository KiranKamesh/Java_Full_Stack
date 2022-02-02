package com.mouritech.onetooneexample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.onetooneexample.model.EmployeeDetails;
import com.mouritech.onetooneexample.util.HibernateUtil;







public class EmployeeDetailsDao {
	public void saveEmployee(EmployeeDetails empDetails) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(empDetails);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public EmployeeDetails getEmployeeDetails(Long empDetailsId) {
		Transaction transaction = null;
		EmployeeDetails empDetailsById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			empDetailsById = session.get(EmployeeDetails.class, empDetailsId);
			if(empDetailsById!=null) {
				
				System.out.println("Employee details are = " + empDetailsById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empDetailsById;
		
	}
}