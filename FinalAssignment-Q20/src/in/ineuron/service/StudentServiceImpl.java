package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.model.Student;

public class StudentServiceImpl implements IStudentService {
	IStudentDao dao = StudentDaoFactory.getStudentDao();

	@Override
	public Student searchStudent(Integer sid) {
		return dao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		return dao.updateStudent(student);
	}
	
}
