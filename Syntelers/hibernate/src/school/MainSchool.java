package school;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hibernate1.Persons;

public class MainSchool {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) throws IOException {
		sessionFactory = createSessionFactory();
		try{
			sessionFactory = createSessionFactory();
			
		}catch (Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		MainSchool student1 = new MainSchool();
		
		List<Object> list = new ArrayList<>();
		//student1.addStudent("Pedro", "Ledesma", "50 Milk Street", "Boston", "97330" );
		//student1.addCouse("Intro to Information System", 4);
		//student1.getDataFromExcelFile();
		
//		ListObject listobject = new ListObject();
//		list = listobject.getDataFromExcelFile("students.xlsx");		
//		for(int i = 0; i < list.size(); i+=5){
//			student1.addStudent(list.get(i).toString(), list.get(i+1).toString(), list.get(i+2).toString(), list.get(i+3).toString(), list.get(i+4).toString());
//		}
		//File Excel reading to get data
		ListObject data = new ListObject();
		list = data.getDataFromExcelFile("courses.xlsx");
		for (int i = 0; i < list.size(); i+=2) {
			//System.out.println(list.get(i));
			
            student1.addCouse(list.get(i).toString(), Integer.parseInt(list.get(i+1).toString()));
        }
	}

	public Integer addStudent(String pname, String plastname, String paddress, String pcity, String zipcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer personid = null;
			
		
		try {
			tx = session.beginTransaction();
			Students p1 = new Students();
			p1.setSname(pname);
			p1.setSlastName(plastname);
			p1.setSaddress(paddress);
			p1.setScity(pcity);
			p1.setSzipcode(zipcode);
			session.save(p1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personid;
	}
	
	public Integer addCouse(String ctitle, int credits) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer personid = null;

		try {
			tx = session.beginTransaction();
			Courses course = new Courses();
			course.setCourseName(ctitle);
			course.setCredits(credits);
			session.save(course);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personid;
	}

	/* Read all the persons from the DB */
	public void listPersons() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List persons = session.createQuery("From Students").list();
			for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
				Students per1 = (Students) iterator.next();
				System.out.print("First Name: " + per1.getSname());
				System.out.print(" Last Name: " + per1.getSlastName());
				System.out.print(" Address: " + per1.getSaddress());
				System.out.print(" City: " + per1.getScity());
				System.out.println();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// method to start a session factory
	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public void updatePerson(Integer PersonID, String city) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Persons per1 = (Persons) session.get(Persons.class, PersonID);
			per1.setCity(city);
			session.update(per1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deletePerson(Integer personID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Persons per1 = (Persons) session.get(Persons.class, personID);
			session.delete(per1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
}
