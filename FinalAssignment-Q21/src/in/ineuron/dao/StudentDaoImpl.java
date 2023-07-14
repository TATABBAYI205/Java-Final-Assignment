package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {
	Session session = HibernateUtil.getSession();
	
	@Override
	public Student searchStudent(Integer sid) {
		return session.get(Student.class, sid);
	}

	@SuppressWarnings("finally")
	@Override
	public String updateStudent(Student student) {
		System.out.println(student);

		Transaction transaction = null;
		Boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.merge(student);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
				return "failure";
			}
		}
	}
	
}
