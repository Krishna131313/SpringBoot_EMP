package com.user_management.Helper;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionHelper {
	
	 public void removeMessageFromSession() {
	        try {
	            System.out.println("removing message form session ");
	            HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	            session.removeAttribute("msg");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
}
