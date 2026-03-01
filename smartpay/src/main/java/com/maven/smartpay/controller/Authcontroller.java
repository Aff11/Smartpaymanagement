package com.maven.smartpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maven.smartpay.model.User;
import com.maven.smartpay.repository.Userrepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Authcontroller {

	@Autowired 
	Userrepository ur;
	
	@GetMapping("/")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login"); 
    }
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest req, HttpSession session) {
		ModelAndView mv=new ModelAndView();
		
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		User user=ur.findByEmailAndPassword(email,pass);
		System.out.println(user);
		
		if(user!=null) {
			session.setAttribute("loggedinuser",user);
			if(user.getRole().equals("ADMIN")) {
				return new ModelAndView("admin-dashboard");
			}
			else {
				return new ModelAndView("user-dashboard");
			}
		}
		return mv;
    }
	@GetMapping("/register")
	public String loginreg() {
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView processregister(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		
		 String name = req.getParameter("name");
		  String email = req.getParameter("email");
		  String pass = req.getParameter("password");
		  String role = req.getParameter("role");
		  
		  if(role==null || role.isEmpty())
			  role="USER";
		  
		  User existinguser=ur.findByEmail(email);
		  if(existinguser!=null) {
			  mv.setViewName("register");
			  mv.addObject("error","email already exists");
			  return mv;
		  }
		  
		  User user=new User();
		  user.setEmail(email);
		  user.setName(name);
		  user.setPassword(pass);
		  user.setRole(role);
		  user.setWallet_balance(0.0);
		  
		  ur.save(user);
		  return new ModelAndView("redirect:/");
	}
}
