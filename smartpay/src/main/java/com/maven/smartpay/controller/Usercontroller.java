package com.maven.smartpay.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maven.smartpay.model.Transaction;
import com.maven.smartpay.model.User;
import com.maven.smartpay.repository.Transactionrepository;
import com.maven.smartpay.repository.Userrepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class Usercontroller {
 
	@Autowired
	Userrepository ur;
	
	@Autowired
	Transactionrepository tr;
	
	@GetMapping("/user/dashboard")
	public ModelAndView userdashboard(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		
		Object user=session.getAttribute("loggedinuser");
		if(user==null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		mv.setViewName("user-dashboard");
		mv.addObject("user",user);
		
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	//addmoney
	@GetMapping("/addMoney")
    public ModelAndView showAddMoneyPage(HttpSession session) {

        if(session.getAttribute("loggedinuser") == null) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("add-money");
    }
	
	@PostMapping("/addMoney")
	public String addMoney(HttpSession session,@RequestParam double amount) {
		User user=(User) session.getAttribute("loggedinuser");
		
		user.setWallet_balance(user.getWallet_balance()+amount);
		ur.save(user);
		session.setAttribute("loggedinuser", user);

		 Transaction t = new Transaction();
		 t.setSender(user);
		 t.setReceiver(user);
		 t.setAmount(amount);
		 t.setStatus("Success");
		 t.setType("Add");
		 t.setCreated_at(LocalDateTime.now());
		 
		 tr.save(t);
		 
		 return "redirect:/user/dashboard";
	}
	
	@GetMapping("/transfer")
	public String logintransfer(HttpSession session) {
		if(session.getAttribute("loggedinuser")==null) {
			return "redirect:/";
		}
		return "transfer";
	}
	
	@PostMapping("/transfer")
	 public ModelAndView transferMoney(HttpSession session,
             @RequestParam String receiverEmail,
             @RequestParam double amount) {
		 ModelAndView mv = new ModelAndView();
		 
		 User sender=(User) session.getAttribute("loggedinuser");
		 User receiver=ur.findByEmail(receiverEmail);
		 
		 if(receiver==null) {
			 mv.setViewName("transfer");
			 mv.addObject("error", "Receiver not found!");
			 return mv;
		 }
		 if(sender.getWallet_balance()<amount) {
			 mv.setViewName("transfer");
			 mv.addObject("error", "not sufficient amount!");
			 return mv;
		 }
		 sender.setWallet_balance(sender.getWallet_balance()-amount);
		 ur.save(sender);
		 
		 receiver.setWallet_balance(receiver.getWallet_balance() + amount);
	     ur.save(receiver);
	     
	     session.setAttribute("loggedinuser", sender);

	     Transaction t = new Transaction();
	     t.setSender(sender);
	     t.setReceiver(receiver);
	     t.setAmount(amount);
	     t.setType("tranfer");
	     t.setStatus("success");
	     t.setCreated_at(LocalDateTime.now());
	     
	     tr.save(t);
	     return new ModelAndView("redirect:/user/dashboard");
	}
	
	@GetMapping("/transactions")
	public ModelAndView viewTransactions(HttpSession session) {

	    User user = (User) session.getAttribute("loggedinuser");

	    if(user == null) {
	        return new ModelAndView("redirect:/");
	    }

	    List<Transaction> list =
	            tr.findBySenderOrReceiver(user, user);

	    ModelAndView mv = new ModelAndView("transactions");
	    mv.addObject("transactions", list);

	    return mv;
	}
}
