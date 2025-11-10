package OneToMany.Curd;

import java.util.Arrays;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College college = new College();
		college.setCid(101);
		college.setCname("Thane College");
		college.setAddress("Thane");
		
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Tony");
		s1.setStd("12th");
		
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("King");
		s2.setStd("12th");
		
		Student s3 = new Student();
		s3.setSid(3);
		s3.setSname("Allen");
		s3.setStd("12th");
		
		college.setStudent(Arrays.asList(s1, s2, s3));
		
		et.begin();
		em.persist(college);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
		
		System.out.println("Data Saved");
	}
}
