package com.T14GString.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

public class AdminPostDAO {

	public boolean DBsave(AdminForm adminForm)
	{
		try{
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(adminForm);
		transaction.commit(); 
		System.out.println("Successfully saved");
		session.flush(); 
		session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public AdminForm DBretrieve(int i)
	{
		AdminForm adminForm =new AdminForm();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		adminForm =  (AdminForm) session.get(AdminForm.class, i);
		transaction.commit(); 
		session.flush(); 
		session.close();
		return adminForm;
	}
}
