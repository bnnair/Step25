package com.in28minutes.springboot.web.controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model, HttpServletRequest request) {
		model.put("name", getLoggedinUserName());
		
		System.out.println("name :" + model.get("name"));
		System.out.println("URL*****************"+ getCurrentUrl(request));
		return "welcome";
	}

	public static String getCurrentUrl(HttpServletRequest request){
	    URL url;
		try {
			url = new URL(request.getRequestURL().toString());
		    String host  = url.getHost();
		    String userInfo = url.getUserInfo();
		    String scheme = url.getProtocol();
		    int port = url.getPort();
		    String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
		    String query = (String) request.getAttribute("javax.servlet.forward.query_string");

		    URI uri = new URI(scheme,userInfo,host,port,path,query,null);
		    return uri.toString();

		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

}
