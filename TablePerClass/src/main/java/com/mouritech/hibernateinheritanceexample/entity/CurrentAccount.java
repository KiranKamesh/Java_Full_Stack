package com.mouritech.hibernateinheritanceexample.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "caccount1")
@AttributeOverrides({
	@AttributeOverride(name = "accno", column = @Column(name = "caccno")),
	@AttributeOverride(name = "accname", column = @Column(name = "caccname"))
})
public class CurrentAccount extends BankAccount{
	
	@Column(name = "ser_charge")
	private Float serviceCharge;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(Float serviceCharge) {
		super();
		this.serviceCharge = serviceCharge;
	}

	public Float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@Override
	public String toString() {
		return "CurrentAccount [serviceCharge=" + serviceCharge + "]";
	}
	
	

}
