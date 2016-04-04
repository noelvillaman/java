package org.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MavenTest {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		/**
		 * Inserting into person_tbl table
		 */
		try
		{
			
			Person ps1 = new Person();
			
			ps1.setName("Noel");
			ps1.setAge(20);
			ps1.setGender('M');
			
			session.save(ps1);
			session.flush();
			tr.commit();
			
			session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			tr.rollback();
		}
	}

}
