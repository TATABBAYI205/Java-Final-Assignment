package service;

import dao.IStudentDao;
import daofactory.StudentDaoFactory;
import dto.Student;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = StudentDaoFactory.getStudentDao();
	
	@Override
	public Student searchStudent(int sid) {
		return studentDao.searchStudent(sid);
	}

}
