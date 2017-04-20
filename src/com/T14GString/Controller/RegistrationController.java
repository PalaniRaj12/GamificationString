package com.T14GString.Controller;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.T14GString.DAO.CompilationDAO;
import com.T14GString.DAO.CompilationForm;
import com.T14GString.DAO.LoginForm;
import com.T14GString.DAO.Registration;
import com.T14GString.DAO.RegistrationDAO;

@Controller
@RequestMapping("registration.html")
public class RegistrationController {
	
	@Autowired
	private RegistrationValidation registrationValidation;
	private RegistrationDAO registrationDAO=new RegistrationDAO();
	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) 
	{
		Registration registration = new Registration();
		model.put("registration", registration);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,BindingResult result,Map model,HttpServletRequest request) 
	{
		registrationValidation.validate(registration, result);
		if (result.hasErrors())
		{
			System.out.println("err");
			return "registrationform";
		}
		for(int i=1;i<=3;i++)
		{
			CompilationForm compilationForm=new CompilationForm();
			compilationForm.setQuestionId(registration.getEmail()+"&"+i);
			compilationForm.setPercentage(0);
			new CompilationDAO().DBsave(compilationForm);
		}
		model.put("loginForm", new LoginForm());
		return "loginform";
		
	}

}
