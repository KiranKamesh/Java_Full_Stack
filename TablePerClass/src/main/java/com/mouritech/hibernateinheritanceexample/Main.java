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
			transaction = session.beginTransaction();

			BankAccount b = new BankAccount();
			b.setAccNo(234442);
			b.setAccName("Loan");
			b.setBalance(24000D);

			CurrentAccount c = new CurrentAccount();
			c.setAccName("Education");
			c.setAccNo(3288383);
			c.setBalance(40007D);
			c.setServiceCharge(34F);

			SavingsAccount s = new SavingsAccount();
			s.setAccNo(343648);
			s.setAccName("Visa");
			s.setBalance(7257237D);
			s.setInterestRate(13F);

			session.save(b);
			session.save(c);
			session.save(s);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
	}

}
