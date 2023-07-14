package test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.Student;
import util.HibernateUtil;


/*
18. Create a Java program that uses Hibernate to connect to a MySQL database and
	 retrieve data from a table. The program should use Hibernate to map the table to a
	 Java object and then display the data on the console.
*/

public class GetRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the id of student :: ");
		int id = scan.nextInt();
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				Student student = session.get(Student.class, id);
				
				if(student != null) {
					System.out.println("Student name    :: "+ student.getSname());
					System.out.println("Student age is  :: "+ student.getSage());
					System.out.println("Student address :: "+student.getSaddress());
					
				} else {
					System.out.println("Record not found for given id "+id);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			scan.close();
		}

	}

}
