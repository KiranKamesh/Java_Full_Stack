package com.mouritech.hibernateinheritanceexample.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cacc112")
@PrimaryKeyJoinColumn(name = "accono")
public class CurrentAccount extends BankAccount {
	@Column(name="emspCharge")
	private float serviceCharge;

	public CurrentAccount() {
		
	}
	
	public CurrentAccount(float serviceCharge) {
		super();
		this.serviceCharge = serviceCharge;
	}

	public float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
}