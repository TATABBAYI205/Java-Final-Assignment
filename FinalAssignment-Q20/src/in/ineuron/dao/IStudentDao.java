package in.ineuron.dao;

import in.ineuron.model.Student;

public interface IStudentDao {
	
	public String updateStudent(Student student);
 
	public Student searchStudent(Integer sid);

}
