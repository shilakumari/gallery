package com.gallery.buyer.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gallery.buyer.model.Shop;
import com.gallery.buyer.service.BuyerService;

@Controller
public class BuyerController {
	private static final Logger logger = Logger.getLogger(BuyerController.class.getName());

	@Autowired
	BuyerService buyerService;

	@RequestMapping("/postMobileNumber")
	public String postMobileNumber(@RequestParam String mobileNumber, Model model) throws Exception {
		String viewName = "";
		logger.info("BuyerController:inside postMobileNumber");
		
		String pinCode = buyerService.getBuyerPinCode(mobileNumber);
		logger.info("pinCode:"+pinCode);
		if (pinCode == null || pinCode.isEmpty()) {
			viewName = "buyer/pinCodeEntry";
		} else {
			List<Shop> shopList = buyerService.getShopList(pinCode);
			model.addAttribute("shopList", shopList);
			viewName = "buyer/gallery";
		}
		logger.info("viewName:"+viewName);
		model.addAttribute("pinCode", pinCode);
		model.addAttribute("mobileNumber", mobileNumber);
		logger.info("BuyerController:returning from  postMobileNumber");
		return viewName;
	}

	@RequestMapping("/postPinCode")
	public String postPinCode(@RequestParam String mobileNumber, @RequestParam String pinCode, Model model)
			throws Exception {
		String viewName = "";

		buyerService.updateBuyerPinCode(mobileNumber, pinCode);

		List<Shop> shopList = buyerService.getShopList(pinCode);
		model.addAttribute("shopList", shopList);
		viewName = "buyer/gallery";

		model.addAttribute("pinCode", pinCode);
		model.addAttribute("mobileNumber", mobileNumber);
		return viewName;
	}

	@RequestMapping("/gallery")
	public String gallery(@RequestParam String mobileNumber, @RequestParam String pinCode,
			Model model) throws Exception {
		System.out.println(mobileNumber);
		System.out.println(pinCode);
		model.addAttribute("mobileNumber", mobileNumber);
		model.addAttribute("pinCode", pinCode);
		return "buyer/gallery";
	}

	@RequestMapping("/mobileNumberEntry")
	public String mobileNumberEntry(Model model) throws Exception {
		model.addAttribute("mobile", "mobileNumber");
		return "buyer/mobileNumberEntry";
	}

}
