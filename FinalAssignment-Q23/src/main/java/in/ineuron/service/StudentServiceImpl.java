package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public String registerStudent(Student student) {
		Integer sid = dao.save(student).getSid();
		return sid != 0 ? "success" : "failed";
	}

	@Override
	public String loginStudent(Integer sid, String password) {
		Optional<Student> optional = dao.findById(sid);
		String loginStatus = "";
		if (optional.isPresent()) {
			Student student = optional.get();
			String password2 = student.getPassword();
			if (password.equals(password2)) {
				loginStatus = "success";
			} else {
				loginStatus = "failed";
			}
		}
		return loginStatus;
	}

}
