package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.business.domain.User;
import com.example.business.repository.UserRepository;

@Controller
public class UserController {
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelAndView mav) {
		mav.addObject("user", new User());
		mav.setViewName("/user/registration");
		return mav;
	}
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("user") User user,ModelAndView mav) {
		userRepository.save(user);
		mav.setViewName("redirect:/user/login");
		return mav;
		
	}

}
