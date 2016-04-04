package hibernate1;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonMain {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(Persons.class).buildSessionFactory();
			
		}catch (Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		PersonMain p1 = new PersonMain(); 
		Integer perid1 = p1.addPerson("Tonny", "Pedroia", "123 Fernwood Cir.", "Corvallis");
		Integer perid2 = p1.addPerson("Vida", "Mia", "50 Milk st. apt 1", "Boston");
		Integer perid3 = p1.addPerson("Sissy", "Ureña", "890 Bonaira Av.", "Santo Domingo Este");
		
		p1.listPersons();
		
		
	}
	
	public Integer addPerson(String pname, String plastname, String paddress, String pcity){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer personid = null;
		
		try
		{
			tx = session.beginTransaction();
			Persons p1 = new Persons();
			p1.setFirstname(pname);
			p1.setLastname(plastname);
			p1.setAddress(paddress);
			p1.setCity(pcity);
			personid = (Integer)session.save(p1);
			tx.commit();
		} catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return personid;
	}
	
	/* Read all the persons from the DB */
	public void listPersons(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List persons = session.createQuery("From Persons").list();
			for(Iterator iterator = persons.iterator(); iterator.hasNext();){
				Persons per1 = (Persons) iterator.next();
				System.out.print("First Name: " + per1.getFirstname());
				System.out.print(" Last Name: " + per1.getLastname());
				System.out.print(" Address: " + per1.getAddress());
				System.out.print(" City: " + per1.getCity());
				System.out.println();
			}
			tx.commit();
		} catch (HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void updatePerson(Integer PersonID, String city){
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Persons per1 = (Persons)session.get(Persons.class, PersonID);
			per1.setCity(city);
			session.update(per1);
			tx.commit();
		} catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deletePerson(Integer personID){
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Persons per1 = (Persons)session.get(Persons.class, personID);
			session.delete(per1);
			tx.commit();
		}catch (HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
