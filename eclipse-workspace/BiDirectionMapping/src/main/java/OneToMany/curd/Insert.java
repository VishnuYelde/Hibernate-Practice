package OneToMany.curd;

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
		
		College c1 = new College();
		c1.setCid(1);
		c1.setCname("Thane College");
		c1.setAddress("Thane");
		
		College c2 = new College();
		c2.setCid(2);
		c2.setCname("Dombivli College");
		c2.setAddress("Dombivli");
		
		Student s1 = new Student();
		s1.setSid(101);
		s1.setSname("Yash");
		s1.setStd("12th");
		s1.setCollege(c1);
		
		Student s2 = new Student();
		s2.setSid(102);
		s2.setSname("Mayur");
		s2.setStd("12th");
		s2.setCollege(c1);
		
		Student s3 = new Student();
		s3.setSid(103);
		s3.setSname("Vishal");
		s3.setStd("12th");
		s3.setCollege(c1);
		
		Student s4 = new Student();
		s4.setSid(104);
		s4.setSname("Vishnu");
		s4.setStd("12th");
		s4.setCollege(c2);
		
		et.begin();
		em.persist(c1);
		em.persist(c2);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
//		em.persist(s4);
		et.commit();
		
		System.out.println("Data Saved Successfully");
	}
}
