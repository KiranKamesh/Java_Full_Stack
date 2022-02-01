package com.mouritech.hibernateinheritanceexample;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.hibernateinheritanceexample.entity.BankAccount;
import com.mouritech.hibernateinheritanceexample.entity.CurrentAccount;
import com.mouritech.hibernateinheritanceexample.entity.SavingsAccount;
import com.mouritech.hibernateinheritanceexample.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			BankAccount b = new BankAccount();
			b.setAccountName("Loan");
			b.setBalence(36368);
			
			CurrentAccount c = new CurrentAccount();
			c.setAccountName("Ramu");
			c.setBalence(1073);
			c.setServiceCharge(32.5f);

			
			
			SavingsAccount s = new SavingsAccount();
			s.setAccountName("Kamla");
			s.setBalence(1073);
			s.setIntersetRate(22.4f);

			// save all the above employee objects in to database
			session.save(b);
			session.save(c);
			session.save(s);
			// commit transaction
			transaction.commit();
		  } catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

}