package com.gallery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	private int id;
	private String mobileNumber;
	private String pincode;

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

	public String getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", mobileNumber=" + mobileNumber + ", pincode=" + pincode + "]";
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
