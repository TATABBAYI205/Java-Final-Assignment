package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.ineuron.util.HibernateUtil;

/*
 19. Create a Java program that uses Hibernate to insert data into a MySQL database
 	 table. The program should use Hibernate to map the table to a Java object and then
	 insert the data into the table. After inserting the data, the program should retrieve it
	 from the database and display it on the console.
 */

public class TestApp {

	static {
		HibernateUtil.startUp();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("WELCOME TO STUDENT DATA MANAGEMENT APP");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3]::  ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}

	}

	private static void selectOperation() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the id of student :: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);

		if (std != null) {
			System.out.println();
			System.out.println("SId\tSNAME\tSAGE\tSADDRESS");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
			System.out.println();
		} else {
			System.out.println("Record not found for the given record :: " + sid);
		}

	}

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name of student :: ");
		String sname = scanner.next();

		System.out.print("Enter the age of student :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the address of studnt :: ");
		String saddress = scanner.next();
		Student student = new Student();
		student.setSname(sname);
		student.setSage((sage));
		student.setSaddress(saddress);

		String msg = studentService.addStudent(student);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Record inserted succesfully...");
		} else {
			System.out.println("Record insertion faild...");
		}

	}

}
