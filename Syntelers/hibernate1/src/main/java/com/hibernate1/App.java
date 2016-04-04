package com.hibernate1;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	private static SessionFactory factory;

	public static void main(String[] args) {
		//Book book1 = new Book("El sol que sale", "Peron Mirado", 1990, 250);
		//Book book2 = new Book("Luna y Sol", "Maria Titas", 2010, 450);
		//Book book3 = new Book("Sale el sol salgo yo", "Eva Peron", 1960, 850);
		//int n = putBooks().length;
		factory = getSessionFactory();
		App book = new App();
		book.listThem();
		//Book[] books1;// = new Book[putBooks().length]; 
				
		//books1 = putBooks();
		
//		for(int i = 0; i < books1.length; i++){
//			create(books1[i]);
//		}
		
		//create(book1);
		//create(book2);
		//create(book3);
	}
	
	public static Book[] putBooks(){
		Scanner scanner = new Scanner(System.in);
		int n;		
		System.out.print("Enter the amount of books you want to: ");
		n = scanner.nextInt();
		Book[] books = new Book[n];
		for(int i = 0; i < books.length; i++){
			books[i] = new Book();
			scanner.nextLine();
			System.out.print("Enter book title: ");
			books[i].setTitle(scanner.nextLine());
			
			//scanner.nextLine();
			System.out.print("Enter book pages: ");
			books[i].setPages(scanner.nextInt());
			
			scanner.nextLine();
			System.out.print("Enter book author: ");
			books[i].setAuthor(scanner.nextLine());
			
			//scanner.nextLine();
			System.out.print("Enter book year: ");
			books[i].setYear(scanner.nextInt());
			//scanner.nextLine();
		}
		return books;
	}
	
	public static SessionFactory getSessionFactory(){
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public static Integer create(Book b){
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(b);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + b.toString());
		return b.getId();
		
	}

	
	
	public void listThem(){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			List books = session.createQuery("From Book").list();
			for(Iterator iterator = books.iterator(); iterator.hasNext();){
				Book book = (Book) iterator.next();
				System.out.print("Title : " + book.getTitle());
				System.out.print(" Author : " + book.getAuthor());
				System.out.print(" Pages: " + book.getPages());
				System.out.print(" Year: " + book.getYear());
				System.out.println();
			}
			tx.commit();
		}catch (HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
	}

}
