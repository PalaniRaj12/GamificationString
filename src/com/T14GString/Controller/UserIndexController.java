package com.T14GString.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.AdminPostDAO;
import com.T14GString.DAO.Registration;
import com.T14GString.DAO.RegistrationDAO;

@Controller
@RequestMapping("userIndex.html")
public class UserIndexController 
{
	@Autowired
	private RegistrationValidation registrationValidation;
	private RegistrationDAO registrationDAO=new RegistrationDAO();
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map<String, Registration> model,HttpServletRequest request) 
	{
		request.getSession().setAttribute("changePasswordErr", "");
		model.put("registration",new Registration());
		return "userIndex";
	}

	
	@RequestMapping(method = RequestMethod.POST, params="changepassword")
	public String profileProcess(Map<String, Registration> model,HttpServletRequest request, Registration registration) 
	{
		request.getSession().setAttribute("changePasswordErr", "");
		if(registration.getConfirmPassword().equals(registration.getPassword()))
		{
			if(registration.getConfirmPassword().length()>=4&&registration.getPassword().length()>=4)
			{
				registration.setEmail(request.getSession().getAttribute("email").toString());
				registration.setUserName(request.getSession().getAttribute("userName").toString());
				boolean b=new RegistrationDAO().DBsave(registration);
				if(b)
					request.getSession().setAttribute("changePasswordErr", "Password Changed successfully");
			}
			else{
				request.getSession().setAttribute("changePasswordErr", "Password Should have atlease 4 letter");
			}
		}
		else{
			request.getSession().setAttribute("changePasswordErr", "Password Mismatching");
		}
		model.put("registration",new Registration());
		return "userIndex";
	}
	@RequestMapping(method = RequestMethod.POST, params="changepassword1")
	public String profileProcess1(Map<String, Registration> model) 
	{
		model.put("registration",new Registration());
		return "userIndex";
	}
	
	
}
