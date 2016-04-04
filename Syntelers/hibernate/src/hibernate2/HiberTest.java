package hibernate2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HiberTest {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Scanner sner = new Scanner(System.in);

	public static void main(String[] args) {
		Object ob = new Object();
		
		
		
		System.out.println("1) Employee Table 2) Login Table");
		System.out.println("Enter the number the number for what you want to do: ");
		int selection = sner.nextInt();
		if (selection == 1) {
			ob = new Employee();
			ob = empInit();
		} else if (selection == 2) {
			ob = new Login();
			ob = empLog();
		} else {

			System.out.println("you did not enter what you were asked");
			// Employee emp = new Employee();
		}
		sessionFactory = createSessionFactory();

		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tran = session.beginTransaction();
		//session.beginTransaction();
		session.save(ob);
		tran.commit();
		session.flush();
	}

	// method to start a session factory
	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static Employee empInit() {
		Employee emp = new Employee();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee name: ");
		emp.setFirstName(scanner.next());
		System.out.println("Enter employee last name: ");
		emp.setLastName(scanner.next());
		System.out.println("Enter employee id: ");
		emp.setId(scanner.nextInt());
		System.out.println("Enter employee Salary: ");
		emp.setSalary(scanner.nextDouble());

		return emp;
	}

	public static Login empLog() {
		Login emplog = new Login();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter login username: ");
		emplog.setUsername(scanner.next());
		System.out.println("Enter login username: ");
		emplog.setPassWord(scanner.next());

		return emplog;
	}

	public static void select() {
	}

}
