package com.gallery.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyerController {
	@RequestMapping("/mobilenoEntry")
	public String getModelAndViewOfMobilenoEntry(Model model) throws Exception {
		model.addAttribute("mobile", "mobileNumber");
		return "buyer/mobilenoEntry";
	}
	@RequestMapping("/pincodeEntry")
	public String getModelAndViewOfMobilenoEntryy(@RequestParam String mobileNumber,Model model) throws Exception {
		model.addAttribute("mobileNumber", mobileNumber);
		return "buyer/pincodeEntry";
	}
	@RequestMapping("/gallery")
	public String getModelAndViewOfMobhjilenoEntryy(@RequestParam String mobileNumber,Model model) throws Exception {
		model.addAttribute("mobileNumber", mobileNumber);
		return "buyer/pincodeEntry";
	}
	
}
