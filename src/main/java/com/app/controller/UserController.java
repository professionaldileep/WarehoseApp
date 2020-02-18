package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping("/reg")
	public String regPage(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, ModelMap map) {
		Integer id=service.saveUser(user);
		String msg="User Registered with id '"+id+"' successfully";
		map.addAttribute("msg", msg);
		return "UserRegister";
	}
	
}
