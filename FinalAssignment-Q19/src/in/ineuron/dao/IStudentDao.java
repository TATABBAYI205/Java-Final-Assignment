package in.ineuron.dao;

import in.ineuron.model.Student;

public interface IStudentDao {
	
	public String addStudent(Student student);
 
	public Student searchStudent(Integer sid);

}
