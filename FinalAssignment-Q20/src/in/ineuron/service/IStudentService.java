package in.ineuron.service;

import in.ineuron.model.Student;

public interface IStudentService {

	public String updateStudent(Student student);
	 
	public Student searchStudent(Integer sid);
}
