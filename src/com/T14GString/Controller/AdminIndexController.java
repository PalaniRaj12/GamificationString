package com.T14GString.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.AdminPostDAO;

@Controller
@RequestMapping("adminIndex.html")
public class AdminIndexController 
{

	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) 
	{
		return "adminIndex";
	}

	
	@RequestMapping(method = RequestMethod.POST, params="Profile")
	public String profileProcess(HttpServletRequest request) 
	{
		return "adminIndex";
	}
	
	@RequestMapping(method = RequestMethod.POST, params="Questions")
	public String questionProcess(Map model,HttpServletRequest request) 
	{
		model.put("adminForm", new AdminForm());
		return "questionview";
	}
	
	@RequestMapping(method = RequestMethod.POST, params="View User Solution")
	public String viewUserPointsProcess(HttpServletRequest request) 
	{
		return "viewusersolution";
	}
	
	
}
