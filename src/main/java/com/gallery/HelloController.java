package com.gallery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gallery.buyer.model.Buyer;

@Controller
//@RequestMapping("/greet")
public class HelloController {

	@Autowired
	SessionFactory sessionFactory;
	// LocalSessionFactoryBean sessionFactory;

	@ModelAttribute
	public void demoModelAttribute2(Model model) {
		System.out
				.println("demoModelAttribute: I will be called before any request handler method of this controller.");
		model.addAttribute("headerMessage", "Sample Header Message from demoModelAttribute2");
	}

	@RequestMapping("/greet2")
	public ModelAndView getModelAndView() throws Exception {
		System.out.println("helloooooooooooooooooo");
		System.out.println("sessionFactory:" + sessionFactory.getSessionFactory().getDialect());
		Session session = sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();

		Buyer buyer = session.get(Buyer.class, 1);
		System.out.println(buyer);

		session.getTransaction().commit();
		session.close();

		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}

	@RequestMapping("/index")
	public ModelAndView getModelAndViewOfIndex() throws Exception {
		System.out.println("index.jsp page");
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	
}