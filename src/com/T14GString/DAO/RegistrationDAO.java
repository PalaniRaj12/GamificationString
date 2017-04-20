package com.T14GString.DAO;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.sql.BatchUpdateException;
import java.util.*;

public class RegistrationDAO {
	
	public boolean DBsave(Registration registration)
	{
		try{
		SessionFactory sеssionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session sеssion = sеssionFactory.openSession();
		Transaction transaction = sеssion.beginTransaction(); 
		sеssion.saveOrUpdate(registration);
		transaction.commit(); 
		System.out.println("Succеssfully saved"); 
		sеssion.flush(); 
		sеssion.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
