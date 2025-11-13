package OneToMany.curd;

import java.util.List;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByCollege {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		College college = em.find(College.class, 1);
		if (college != null) {
			
			System.out.println("============College Details============");
			System.out.println("College ID: "+college.getCid());
			System.out.println("College Name: "+college.getCname());
			System.out.println("College Address: "+college.getAddress());
			
			List<Student> sList = college.getStudents();
			for (Student student : sList) {
				System.out.println("============Student Details============");
				System.out.println("Student ID: "+student.getSid());
				System.out.println("Student Name: "+student.getSname());
				System.out.println("Student Std: "+student.getStd());
			}
			
		} else {
			System.out.println("College Not Found");
		}
	}
}
