package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		//session.invalidate();
		session.setAttribute("registrado",0);
		return "login.jsp";
	}
}
