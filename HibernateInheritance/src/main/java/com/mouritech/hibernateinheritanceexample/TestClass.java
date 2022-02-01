package com.mouritech.hibernateinheritanceexample;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.hibernateinheritanceexample.entity.BankAccount;
import com.mouritech.hibernateinheritanceexample.entity.CurrentAccount;
import com.mouritech.hibernateinheritanceexample.entity.SavingsAccount;
import com.mouritech.hibernateinheritanceexample.util.HibernateUtil;

public class TestClass {

	public static void main(String[] args) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start the transaction
			transaction = session.beginTransaction();
			BankAccount b = new BankAccount();
			b.setAccName("Salary");
			b.setAccNo("6534232323");
			b.setBalance(40000D);
			
			CurrentAccount c = new CurrentAccount();
			c.setServiceCharge(300F);
			
			SavingsAccount s = new SavingsAccount();
			s.setInterestRate(30F);
			
			session.save(b);
			session.save(c);
			session.save(s);
			
			//commit the transaction
			
			transaction.commit();
		}catch(Exception e){
			if(transaction!= null){
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
