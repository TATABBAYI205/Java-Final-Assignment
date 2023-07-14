package daofactory;

import persistence.IStudentDao;
import persistence.StudentDaoImpl;

//Abstraction logic of implementation
public class StudentDaoFactory {
	
	//make constructor private to avoid object creation 
	private StudentDaoFactory() {} 
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		
		//singleton pattern code
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
