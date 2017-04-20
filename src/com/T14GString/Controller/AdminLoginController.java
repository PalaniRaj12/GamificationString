package com.T14GString.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.LoginForm;

@Controller
@RequestMapping("adminloginform.html")
public class AdminLoginController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) 
	{
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "adminloginform";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
	
	public String processForm(@Valid LoginForm loginForm, BindingResult result,Map model,HttpServletRequest request)
	{
		String email="admin@gmail.com";
		String password="password";
		if (result.hasErrors()) 
		{
			return "adminloginform";
		}
		loginForm = (LoginForm) model.get("loginForm");
		
		if (!loginForm.getPassword().equals(password) || !loginForm.getEmail().equals(email)) {
			System.out.println("wrong password");
			return "adminloginform";
		}
		System.out.println("login successfull");
		request.getSession().setAttribute("logout", "login");
		return "adminIndex";
		}
}
