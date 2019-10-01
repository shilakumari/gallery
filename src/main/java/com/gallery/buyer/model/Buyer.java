package com.gallery.buyer.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	private int id;
	private String mobileNumber;
	private String pinCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPinCode() {
		return pinCode;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", mobileNumber=" + mobileNumber + ", pincode=" + pinCode + "]";
	}

	public void setPinCode(String pincode) {
		this.pinCode = pincode;
	}
}
