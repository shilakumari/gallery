package com.gallery.buyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gallery.buyer.model.Shop;
import com.gallery.buyer.dao.BuyerDao;
import com.gallery.buyer.model.Buyer;

@Service
public class BuyerService {

	@Autowired
	BuyerDao buyerDao;

	public String getBuyerPinCode(String mobileNumber) {
		String pinCode = null;
		Buyer buyer = buyerDao.getBuyer(mobileNumber);
		if (buyer == null) {
			buyerDao.saveBuyer(mobileNumber);
		} else {
			if (buyer.getPinCode() != null) {
				pinCode = buyer.getPinCode();
			}
		}
		return pinCode;
	}

	public void updateBuyerPinCode(String mobileNumber, String pinCode) {

		buyerDao.updateBuyerPinCode(mobileNumber, pinCode);

	}

	public List<Shop> getShopList(String pinCode) {
		return buyerDao.getShopList(pinCode);

	}

}
