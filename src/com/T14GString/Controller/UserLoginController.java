package com.T14GString.Controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.T14GString.DAO.AdminPostDAO;
import com.T14GString.DAO.CompilationForm;
import com.T14GString.DAO.LoginForm;
import com.T14GString.DAO.Registration;

@Controller
@RequestMapping("userloginform.html")
public class UserLoginController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) 
	{
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
	
	public String processForm(@Valid LoginForm loginForm, BindingResult result,Map<String, Object> model,HttpServletRequest request)
	{
		String userName="";
		HttpSession session=request.getSession();
		if (result.hasErrors()) 
		{
			return "loginform";
		}
		loginForm = (LoginForm) model.get("loginForm");
		Session session1 = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction transaction = session1.beginTransaction();
		 Query query = session1.createQuery("SELECT registration FROM Registration registration WHERE registration.email = :email ");
		 query.setParameter("email",loginForm.getEmail() );
		 List<?> results = query.list();
		 try
		 {
			 Registration reg=(Registration) results.get(0);
		 String password=reg.getPassword();
		 userName=reg.getUserName();
		transaction.commit();  
		session1.flush(); 
		session1.close();
		
		if (!loginForm.getPassword().equals(password))
			return "loginform";
		
		 }
		 catch(IndexOutOfBoundsException e)
		 {
			 System.out.println("no email exist");
			 return "loginform";
		 }
		session.setAttribute("email", loginForm.getEmail());
		session.setAttribute("userName", userName);
		File f,f1 = null;
		f = new File("H:\\Studies Full\\CIRCUITS\\imp\\JAVA--Software\\eclipse-jee-luna-SR1a-win32\\eclipse\\Main.java");
		f1 = new File("H:\\Studies Full\\CIRCUITS\\imp\\JAVA--Software\\eclipse-jee-luna-SR1a-win32\\eclipse\\Main.class");
		try {
			f.delete();
			f1.delete();
		}catch(Exception e){
		}
		session.setAttribute("changePasswordErr", "");
		model.put("registration", new Registration());
		return "userIndex";
		/*
		
		StringBuffer sb=new StringBuffer("");
		sb.append("import java.util.*;\nimport java.io.*;\nimport java.lang.*;\npublic class Main\n{\n  private static String inputString,outputString;\n  public static void main(String[] args)\n  {\n    funtion();\n    System.out.println(outputString);\n  }\n  private static void funtion()\n  {\n  //code here...\n  }\n}");
		CompilationForm compilationForm=new CompilationForm();
		compilationForm.setQuestionId((String)session.getAttribute("email")+1);
		session.setAttribute("qid", 1); 
		model.put("compilationForm", compilationForm);
		model.put("adminForm", new AdminPostDAO().DBretrieve(1));
		model.put("loginForm", loginForm);
		return "compilationform";*/
	}
}
