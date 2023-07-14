package in.ineuron.service;

import in.ineuron.model.Student;

public interface IStudentService {
	public String registerStudent(Student student);
	public String loginStudent(Integer sid, String password);
}
