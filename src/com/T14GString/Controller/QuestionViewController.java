package com.T14GString.Controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.AdminPostDAO;
import com.T14GString.DAO.LoginForm;
import com.T14GString.DAO.Registration;

@Controller
@RequestMapping("questionview.html")
public class QuestionViewController 
{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) 
	{
		return "questionview";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
	
	public String processForm(@Valid LoginForm loginForm, BindingResult result,Map<String, Object> model,HttpServletRequest request)
	{
		return "questionview";
	}
	
	@RequestMapping(method = RequestMethod.POST, params="Edit1")
	public String Edit1Process(Map<String, AdminForm> model,HttpServletRequest request) 
	{
		
		model.put("adminForm", new AdminPostDAO().DBretrieve(1));
		return "adminpostform";
	}
	@RequestMapping(method = RequestMethod.POST, params="Edit2")
	public String Edit2Process(Map<String, AdminForm> model,HttpServletRequest request) 
	{
		
		model.put("adminForm", new AdminPostDAO().DBretrieve(2));
		return "adminpostform";
	}
	@RequestMapping(method = RequestMethod.POST, params="Edit3")
	public String Edit3Process(Map<String, AdminForm> model,HttpServletRequest request) 
	{
		
		model.put("adminForm", new AdminPostDAO().DBretrieve(3));
		return "adminpostform";
	}
}
