package com.vrushil.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	@RequestMapping("home")
	public ModelAndView home() {

		System.out.println("In print function");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("student")
	//public ModelAndView student(@RequestParam("email") String email,@RequestParam("college") String college,@RequestParam("major") String major,@RequestParam("gpa") String gpa) {
	public ModelAndView student(Student student) {

		System.out.println("In student page");
		ModelAndView mv = new ModelAndView();
		
		/*
		 * mv.addObject("email",email);
		 * 
		 * mv.addObject("college",college); mv.addObject("major",major);
		 * mv.addObject("gpa",gpa);
		 */
		mv.addObject(student);
		 
		  mv.setViewName("student");
		  Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			Session session = sf.openSession();
			session.beginTransaction();		
			
			session.save(student);
		 session.getTransaction().commit();
		return mv;
	}

}
