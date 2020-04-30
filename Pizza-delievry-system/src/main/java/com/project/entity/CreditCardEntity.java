package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pos_tbl_creditcard")
public class CreditCardEntity {

	@Id
	@Column(name = "CreditCardint")
	private String creditCardNumber;
	
	@Column(name = "ValidFrom")
	private String validFrom;
	
	@Column(name = "ValidTo")
	private String validTo;
	
	@Column(name = "Balance")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserEntity userId;

	public CreditCardEntity() {
		super();
		
	}

	public CreditCardEntity(String creditCardNumber, String validFrom, String validTo, double balance) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.balance = balance;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardEntity other = (CreditCardEntity) obj;
		if (creditCardNumber == null) {
			if (other.creditCardNumber != null)
				return false;
		} else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCardEntity [creditCardNumber=" + creditCardNumber + ", validFrom=" + validFrom + ", validTo="
				+ validTo + ", balance=" + balance + ", userId=" + userId + "]";
	}
	
	
}
