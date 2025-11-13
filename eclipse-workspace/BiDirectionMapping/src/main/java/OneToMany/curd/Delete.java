package OneToMany.curd;

import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student student = em.find(Student.class, 103);
		if (student != null) {
			
			
			
			et.begin();
			em.remove(student);
			et.commit();
			
			System.out.println("Data Removed Successfully");
		} else {
			System.out.println("Student Not Found");
		}
	}
}
