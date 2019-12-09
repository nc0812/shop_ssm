package com.nc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
 
     @RequestMapping("/login")
     public String login() {
    	 return "fore/login";
     }
     @RequestMapping("/register")
     public String register() {
    	 return "fore/register";
     }
     
	
}
