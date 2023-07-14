package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public String insertStudent(Student student) {
		Integer sid = dao.save(student).getSid();
		return sid != 0 ? "Student reecord inserted successfully with id " + sid : "Student record insertion failed";
	}

}
