package OneToMany.curd;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		Student student = em.find(Student.class, 104);
		if (student != null) {
			System.out.println("============Student Details============");
			System.out.println("Student ID: "+student.getSid());
			System.out.println("Student Name: "+student.getSname());
			System.out.println("Student Std: "+student.getStd());
			
			College college = student.getCollege();
			System.out.println("============College Details============");
			System.out.println("College ID: "+college.getCid());
			System.out.println("College Name: "+college.getCname());
			System.out.println("College Address: "+college.getAddress());
			
		} else {
			System.out.println("Student Not Found");
		}
	}
}
