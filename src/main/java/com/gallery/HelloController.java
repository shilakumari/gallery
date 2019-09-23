package com.gallery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/greet")
public class HelloController {
	
	@Autowired
	SessionFactory sessionFactory;
	//LocalSessionFactoryBean sessionFactory;
	@RequestMapping("/greet2")
	public ModelAndView getModelAndView() throws Exception {
		System.out.println("helloooooooooooooooooo");
		System.out.println("sessionFactory:"+sessionFactory.getSessionFactory().getDialect());
		Session session=sessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee employee=session.get(Employee.class, 4 );
		System.out.println(employee);
		
		session.getTransaction().commit();
		session.close();
		
		
		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}
	
	@RequestMapping("/")
	public ModelAndView getModelAndViewhj() throws Exception {
		System.out.println("helloooooooooooooooooo");
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
}