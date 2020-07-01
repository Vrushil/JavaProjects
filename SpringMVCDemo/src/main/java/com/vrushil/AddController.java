package com.vrushil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vrushil.service.AddService;

@Controller 
public class AddController {

	/*
	 * @RequestMapping(path="/add") public void add()
	 * 
	 * { System.out.println("In add method"); }
	 */
	
	
	/*
	 * @RequestMapping(path="/add") public String add(HttpServletRequest request,
	 * HttpServletResponse repsonse)
	 * 
	 * { int i= Integer.parseInt(request.getParameter("t1")); int j=
	 * Integer.parseInt(request.getParameter("t2")); int k= i+j;
	 * 
	 * return"Display.jsp"; }
	 */

	
	/* Logical processing should not be done in the controller it should be done in the service method */
	@RequestMapping(path="/add")
	// Request Param  gets rid of request.getParam and directly  assigns int to t1 and t2
	public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int j,HttpServletRequest request, HttpServletResponse repsonse)
	
	{
		/*
		 * int i= Integer.parseInt(request.getParameter("t1")); int j=
		 * Integer.parseInt(request.getParameter("t2"));
		 *///int k= i+j;
			
				
				AddService as= new AddService();
						
				int k= as.add(i, j);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("Display");
				mv.addObject("result", k);
				return mv;
				}
	
}
