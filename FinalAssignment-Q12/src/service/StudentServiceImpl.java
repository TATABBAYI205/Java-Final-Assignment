package service;

import daofactory.StudentDaoFactory;
import dto.Student;
import persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao ;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		studentDao = StudentDaoFactory.getStudentDao(); 
		return studentDao.addStudent(sname, sage, saddress); 
	} 

	@Override
	public Student searchStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student); 
	}

	@Override
	public String deleteStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
