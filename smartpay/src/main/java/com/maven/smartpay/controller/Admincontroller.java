package com.maven.smartpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maven.smartpay.model.Transaction;
import com.maven.smartpay.model.User;
import com.maven.smartpay.repository.Transactionrepository;
import com.maven.smartpay.repository.Userrepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class Admincontroller {

	@Autowired
	private Userrepository ur;
	
	@Autowired
	private Transactionrepository tr;
	
	@GetMapping("/admin-dashboard")
	public ModelAndView admindashboard(HttpSession session) {
		User user=(User) session.getAttribute("loggedinuser");
		
		if (user == null || !user.getRole().equals("ADMIN")) {
            return new ModelAndView("redirect:/");
        }
		
		return new ModelAndView("admin-dashboard");
	}
	
	@GetMapping("/admin/users")
	  public ModelAndView viewAllUsers(HttpSession session) {
		User user=(User) session.getAttribute("loggedinuser");
		 if (user == null || !user.getRole().equals("ADMIN")) {
	            return new ModelAndView("redirect:/");
	        }
		List<User>users=ur.findAll();
		ModelAndView mv = new ModelAndView("all-users");
        mv.addObject("users", users);
        
        return mv;
	}
	
	@GetMapping("/admin/transactions")
	public ModelAndView viewAllTransactions(HttpSession session) {
		User user=(User) session.getAttribute("loggedinuser");
		 if (user == null || !user.getRole().equals("ADMIN")) {
	            return new ModelAndView("redirect:/");
	        }
		 List<Transaction> transactions = tr.findAll();

	        ModelAndView mv = new ModelAndView("all-transactions");
	        mv.addObject("transactions", transactions);

	        return mv;
	}
}
