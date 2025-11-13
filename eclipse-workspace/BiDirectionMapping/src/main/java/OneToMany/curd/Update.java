package OneToMany.curd;

import java.util.List;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College college = em.find(College.class, 1);
		if (college != null) {
			et.begin();
			
			college.setCname("Thane Junior College");
			
			List<Student> sList = college.getStudents();
			for (Student student : sList) {
				if (student.getSid() == 101) {
					student.setSname("Yash Govare");
					break;
				}
				em.merge(student);
			}
			em.merge(college);
			et.commit();
			
			System.out.println("Details Saved Successfully");
		} else {
			System.out.println("College Not Found");
		}
	}
}
