package com.mouritech.hibernateinheritanceexample.entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "bankacc11")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accno")
	private Integer accNo;
	@Column(name = "accname")
	private String accName;
	@Column(name = "bal")
	private Double balance;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accName, Double balance) {
		super();
		this.accName = accName;
		this.balance = balance;
	}

	public BankAccount(Integer accNo, String accName, Double balance) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.balance = balance;
	}

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", balance=" + balance + "]";
	}
	
	
	

}
