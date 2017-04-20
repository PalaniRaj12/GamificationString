package com.T14GString.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Response;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.T14GString.DAO.AdminForm;
import com.T14GString.DAO.AdminPostDAO;
import com.T14GString.DAO.CompilationDAO;
import com.T14GString.DAO.CompilationForm;
import com.T14GString.DAO.CompilationService;
import com.T14GString.DAO.FileValidator;
import com.T14GString.DAO.LoginForm;
import com.T14GString.DAO.Registration;

@Controller
@RequestMapping("compilationform.html")
public class CompilationController {
	private CompilationDAO compilationDAO;
	
	@Autowired
    private FileValidator fileValidator;
	
	public void setFileValidator(
			FileValidator fileValidator) {
		this.fileValidator = fileValidator;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String showform(Map<String, Object> model,AdminForm adminForm,CompilationForm compilationForm,HttpServletRequest request) 
	{
		HttpSession session=request.getSession();
		model.put("compilationForm", compilationForm);
		AdminForm adminform=new AdminPostDAO().DBretrieve((int)session.getAttribute("qid"));
		model.put("adminForm",adminform);
		return "compilationform";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, params="Run", value="Run")
	public String showForm(Map<String, Object> model,AdminForm adminForm,CompilationForm compilationForm) 
	{
		model.put("compilationForm", compilationForm);
		model.put("adminForm",new AdminPostDAO().DBretrieve(adminForm.getQuestionId()));
		return "compilationform";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, params="Run", value="Run")
	public String processForm(@Valid CompilationForm compilationForm, BindingResult result,Map<String, Object> model,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		AdminForm adminForm=new AdminPostDAO().DBretrieve((int)session.getAttribute("qid"));
		compilationForm.setQuestionId((String)session.getAttribute("email")+"&"+(int)session.getAttribute("qid"));
		new CompilationDAO().DBsave(compilationForm);
		model.put("adminForm",adminForm);
		session.setAttribute("err", "");
		session.setAttribute("result"+session.getAttribute("qid"), "");
		FileValidator.validateCompilationForm(compilationForm, request);
		compilationForm=new CompilationDAO().compileCode(compilationForm,adminForm.getInputString());
		compilationForm.setQuestionId((String)session.getAttribute("email")+"&"+(int)session.getAttribute("qid"));
		new CompilationDAO().DBsave(compilationForm);
		compilationForm.setCheckbox(false);
		
		String[] resultString=compilationForm.getStdout().split(System.getProperty("line.separator"));
		System.out.println("last result is "+resultString[resultString.length-1]);
		if(resultString[resultString.length-1].trim().equals(adminForm.getResultantString()))
			session.setAttribute("result"+session.getAttribute("qid"), "Correct");
		
		
		//if(compilationForm.getStdout().trim().equals(adminForm.getResultantString()))
			//session.setAttribute("result"+session.getAttribute("qid"), "Correct");
		System.out.println(compilationForm.getStdout().trim().length());
		System.out.println(session.getAttribute("result"+session.getAttribute("qid")));
		model.put("compilationForm", compilationForm);
		return "compilationform";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, params="Submit", value="Submit")
	public String processSubmit(@Valid CompilationForm compilationForm, BindingResult result,Map<String, Object> model,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		AdminForm adminForm=new AdminPostDAO().DBretrieve((int)session.getAttribute("qid"));
		compilationForm.setQuestionId((String)session.getAttribute("email")+"&"+(int)session.getAttribute("qid"));
		new CompilationDAO().DBsave(compilationForm);
		//model.put("adminForm",adminForm);
		session.setAttribute("err", "");
		session.setAttribute("result"+session.getAttribute("qid"), "");
		FileValidator.validateCompilationForm(compilationForm, request);
		compilationForm=new CompilationDAO().compileCode(compilationForm,adminForm.getInputString());
		compilationForm.setQuestionId((String)session.getAttribute("email")+"&"+(int)session.getAttribute("qid"));
		new CompilationDAO().DBsave(compilationForm);
		compilationForm.setCheckbox(false);
		String[] resultString=compilationForm.getStdout().split(System.getProperty("line.separator"));
		System.out.println("last result is "+resultString[resultString.length-1]);
		session.setAttribute("resultString"+session.getAttribute("qid"), resultString[resultString.length-1]);
		if(resultString[resultString.length-1].trim().equals(adminForm.getResultantString()))
			session.setAttribute("result"+session.getAttribute("qid"), "Correct");
		//model.put("compilationForm", compilationForm);
		if(session.getAttribute("result"+session.getAttribute("qid")).equals("Correct"))
			new CompilationService().verifyTestCase(compilationForm,adminForm);
		new CompilationDAO().DBsave(compilationForm);
		request.getSession().setAttribute("changePasswordErr", "");
		model.put("registration",new Registration());
		return "userIndex";
	}
	
	@RequestMapping(method = RequestMethod.POST,params="1")
	public String qid1(Map<String, Object> model,CompilationForm compilationForm,AdminForm adminForm,HttpServletRequest request)
	{
		model.put("adminForm", new AdminPostDAO().DBretrieve(1));
		model.put("compilationForm", new CompilationDAO().DBretrieve((String)request.getSession().getAttribute("email")+"&1"));
		request.getSession().setAttribute("qid", 1);
		return "compilationform";
	}
	@RequestMapping(method = RequestMethod.POST,params="2")
	public String qid2(Map<String, Object> model,CompilationForm compilationForm,AdminForm adminForm,HttpServletRequest request)
	{
		model.put("adminForm", new AdminPostDAO().DBretrieve(2));
		model.put("compilationForm", new CompilationDAO().DBretrieve((String)request.getSession().getAttribute("email")+"&2"));
		request.getSession().setAttribute("qid", 2);
		return "compilationform";
	}
	@RequestMapping(method = RequestMethod.POST,params="3")
	public String qid3(Map<String, Object> model,CompilationForm compilationForm,AdminForm adminForm,HttpServletRequest request)
	{
		model.put("adminForm", new AdminPostDAO().DBretrieve(3));
		model.put("compilationForm", new CompilationDAO().DBretrieve((String)request.getSession().getAttribute("email")+"&3"));
		request.getSession().setAttribute("qid", 3);
		return "compilationform";
	}
	@RequestMapping(method = RequestMethod.POST,params="Go Back")
	public String Goback(Map<String, Object> model,HttpServletRequest request)
	{
		model.put("registration",new Registration());
		return "userIndex";
	}
	
}

