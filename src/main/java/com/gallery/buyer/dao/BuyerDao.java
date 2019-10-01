package com.gallery.buyer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gallery.buyer.model.Buyer;
import com.gallery.buyer.model.Shop;

@Repository
public class BuyerDao {
	@Autowired
	SessionFactory sessionFactory;

	public Buyer getBuyer(String mobileNumber) {
		Session session = sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();

		Buyer buyer = null;
		org.hibernate.Query query = session.createQuery("from Buyer where mobileNumber=:mobileNumber");
		query.setString("mobileNumber", mobileNumber);
		List<Buyer> buyerList = query.list();
		System.out.println(buyerList);
		for (Buyer b : buyerList) {
			buyer = b;
		}
		System.out.println(buyer);

		session.getTransaction().commit();
		session.close();

		return buyer;
	}

	public void saveBuyer(String mobileNumber) {
		Session session = sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();

		Buyer buyer = new Buyer();
		buyer.setMobileNumber(mobileNumber);

		Integer id = (Integer) session.save(buyer);
		System.out.println(id);

		session.getTransaction().commit();
		session.close();
	}

	public void updateBuyerPinCode(String mobileNumber, String pinCode) {

		Session session = sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();

		Buyer buyer = null;
		org.hibernate.Query query = session.createQuery("from Buyer where mobileNumber=:mobileNumber");
		query.setString("mobileNumber", mobileNumber);
		List<Buyer> buyerList = query.list();
		System.out.println(buyerList);
		for (Buyer b : buyerList) {
			buyer = b;
		}
		System.out.println(buyer);

		buyer.setPinCode(pinCode);

		Integer id = (Integer) session.save(buyer);
		System.out.println(id);

		session.getTransaction().commit();
		session.close();

	}

	public List<Shop> getShopList(String pinCode) {
		List<Shop> shopList=null;

		Session session = sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();

		org.hibernate.Query query = session.createQuery("from Shop where pinCode=:pinCode");
		query.setString("pinCode", pinCode);
		shopList = query.list();
		
		session.getTransaction().commit();
		session.close();
		return shopList;
	}

}
