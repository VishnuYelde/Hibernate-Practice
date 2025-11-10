package OneToMany.Curd;

import java.util.List;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		College college = em.find(College.class, 101);
		
		
		if (college != null) {
			System.out.println("===============College data===============");
			System.out.println("College ID: " +college.getCid());
			System.out.println("College Name: " +college.getCname());
			System.out.println("College Address: " +college.getAddress());
			System.out.println("------------------------------------------");
			
			List<Student> sList = college.getStudent();
			
			System.out.println("===============Student data===============");
			for (Student student : sList) {
				System.out.println("Student ID: " +student.getSid());
				System.out.println("Student Name: " +student.getSname());
				System.out.println("Student STD: " +student.getStd());
				System.out.println("------------------------------------------");
			}
			
		} else {
			System.out.println("Data Not Found");
		}
	}
}
