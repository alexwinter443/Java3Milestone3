package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.MilestoneApplication;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/main")

public class UserController {
	
	
	@GetMapping("/home")
	public String homePage(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Vacation Site");
		model.addAttribute("userModel", new UserModel());
		int users=1;
		model.addAttribute("users", users);
		return "homePage";
	}
	
	@GetMapping("/login")
	public String display(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model, @CookieValue(value = "username", defaultValue = "Atta") String username, 
			@CookieValue(value = "password", defaultValue = "Atta") String password) {
		// check for errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		// if the username or password does not equal the hardcoded values
		else if (!userModel.getUsername().trim().equals(username) || !userModel.getPassword().trim().equals(password)) {
			// login has failed
			model.addAttribute("userModel", userModel);
			return "LoginFailed";
		}
	
		// if no errors and credentials are correct, successful login
		model.addAttribute("userModel", userModel);
		return "LoginSuccess";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		// Display Register Form View
		model.addAttribute("title", "Registration Form");
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model, HttpServletResponse response) {
		// check for errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
			return "register";
		}
		
		model.addAttribute("userModel", userModel);
		
		Cookie cookie = new Cookie("username", userModel.getUsername());
		Cookie cookie2 = new Cookie("password", userModel.getPassword());
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		UserModel usr1 = new UserModel(userModel.getUsername(), userModel.getPassword());
		//list.add(usr1);
		// System.out.println(userModel.toString());
		// System.out.println(userModel.getFirstname() + " " + userModel.getLastname() +  " " + userModel.getEmail() +  " " + userModel.getPhone());
		return "RegisterSuccess";
	}
}