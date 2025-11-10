package OneToMany.Curd;

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

		College college = em.find(College.class, 101);
		if (college != null) {
			college.setCname("Thane Engineering College");
			List<Student> sList = college.getStudent();
			for (Student student : sList) {
				if (student.getSid() == 1) {
					student.setSname("Tony Stark");
				}
			}

			// If we want to update only student data by using Student ID
//			Student s = em.find(Student.class, 1);
//			if (s != null) {
//			    et.begin();
//			    s.setSname("Tony Stark");
//			    et.commit();
//			}

			et.begin();
			em.merge(college);
			et.commit();

			System.out.println("College and Student Data Saved Successfully");

		} else {
			System.out.println("College Not Found");
		}

	}
}
