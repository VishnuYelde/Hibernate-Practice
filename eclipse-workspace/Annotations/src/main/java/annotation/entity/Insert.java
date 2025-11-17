package annotation.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		User user = new User();
		user.setName("vishnu");
		user.setEmail("vishu@gmail.com");
		user.setPhone(1234567890);
		
		et.begin();
		em.persist(user);
		et.commit();
		
		System.out.println("Data Saved Successfully");
	}
}
