package assignment1216;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class MainClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		Transaction  tx = session.beginTransaction();
		EmployeeInfo  emp = new EmployeeInfo();
		emp.setEmp_name("Noel Villaman");
		session.save(emp);
		tx.commit();
		session.close();
	}

}
