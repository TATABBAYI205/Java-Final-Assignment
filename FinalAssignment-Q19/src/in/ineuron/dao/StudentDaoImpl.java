package in.ineuron.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {
	Session session = HibernateUtil.getSession();
	
	
	@Override
	public String addStudent(Student student) {
		Transaction transaction =null;
		boolean flag = false;
		String msg = "";
	
		try {
			
			if(session != null) 
				transaction = session.beginTransaction();
			if(transaction != null) {

				session.save(student);
				flag = true;
				
			}
			
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				msg = "success";
			} else {
				transaction.rollback();
				msg = "failure";
			}
			
		}
		return msg;
	}
	@Override
	public Student searchStudent(Integer sid) {
		return session.get(Student.class, sid);
	}
	
}
