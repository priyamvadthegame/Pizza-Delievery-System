package com.project.json;



public class CreditCardJson {
	
	private Long creditCardNumber;
	
	
	private String validFrom;
	
	
	private String validTo;
	
	
	private double balance;


	public Long getCreditCardNumber() {
		return creditCardNumber;
	}


	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public String getValidFrom() {
		return validFrom;
	}


	public CreditCardJson() {
		super();
		
	}


	public CreditCardJson(Long creditCardNumber, String validFrom, String validTo, double balance) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.balance = balance;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardJson other = (CreditCardJson) obj;
		if (creditCardNumber == null) {
			if (other.creditCardNumber != null)
				return false;
		} else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CreditCardJson [creditCardNumber=" + creditCardNumber + ", validFrom=" + validFrom + ", validTo="
				+ validTo + ", balance=" + balance + "]";
	}
	
	
	
	
}
