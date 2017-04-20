package com.T14GString.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("fileValidator")
public class  FileValidator {
	
	public boolean supports(Class<?> klass) {
		return CompilationForm.class.isAssignableFrom(klass);
	}

	public static boolean validateCompilationForm(CompilationForm compilationForm,HttpServletRequest request)
	{
		if(compilationForm.isCheckbox()){
	    	if(!compilationForm.getFile().isEmpty())
	    	{
		        if (!(compilationForm.getFile().getOriginalFilename().split("\\.")[1]).equals("txt"))
		        {
		            request.getSession().setAttribute("err", "upload text file");
		        }
		        else if (compilationForm.getFile() != null && compilationForm.getFile().isEmpty())
		        {
		        	request.getSession().setAttribute("err", "file is empty");
		        }
	    	}
	    	else{
	    		request.getSession().setAttribute("err", "select file");
	    	}
       }
       else
       { 
    	   if(compilationForm.getCode()==null||compilationForm.getCode().length()==0)
    	   {
    		   request.getSession().setAttribute("err", "code must not be blank");
    	   }
    	   else 
    	   {
    		   return false;
    	   }
       }
		return true;
	}
	public static void validate(Object target, Errors errors) {
		
		CompilationForm compilationForm = (CompilationForm) target;
		 
       if(compilationForm.isCheckbox()){
	    	if(!compilationForm.getFile().isEmpty())
	    	{
		        if (!(compilationForm.getFile().getOriginalFilename().split("\\.")[1]).equals("txt"))
		        {
		            errors.rejectValue("code", "upload.txt.file");
		        }
		        if (compilationForm.getFile() != null && compilationForm.getFile().isEmpty())
		        {
		            errors.rejectValue("code", "file.empty");
		        }
	    	}
	    	else{
	    		errors.rejectValue("code", "select.file");
	    	}
       }
       else
       { 
    	   if(compilationForm.getCode()==null||compilationForm.getCode().length()==0)
    	   {
    		    errors.rejectValue("code", "type.code.here");
    	   }
       }
        
	}
}
