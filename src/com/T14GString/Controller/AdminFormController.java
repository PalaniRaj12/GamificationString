package com.T14GString.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.AdminPostDAO;
import com.T14GString.DAO.LoginForm;
import com.T14GString.DAO.Registration;
import com.T14GString.DAO.RegistrationDAO;

@Controller
@RequestMapping("adminpostform.html")
public class AdminFormController {
	
	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) 
	{
		AdminForm adminForm=new AdminForm();
		model.put("adminForm", adminForm);
		return "adminpostform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid AdminForm adminForm,BindingResult result,Map model,HttpServletRequest request) 
	{
		request.getSession().setAttribute("post", "");
		if (result.hasErrors())
		{
			System.out.println("err");
			return "adminpostform";
		}
		boolean b=new AdminPostDAO().DBsave(adminForm);
		if(b)
		request.getSession().setAttribute("post", "successfully posted");
		model.put("adminForm", adminForm);
		return "questionview";
	}
	
	@RequestMapping(method = RequestMethod.POST, params="Go Back")
	public String GoBackProcess(Map model) 
	{
		return "questionview";
	}
	
}
