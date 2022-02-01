package com.mouritech.hibernateinheritanceexample.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("saccount")
public class SavingsAccount extends BankAccount {

	@Column(name = "int_rate")
	private Float interestRate;
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(Float interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public Float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
	
}
