package ManyToOne.Curd;

import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Review review = em.find(Review.class, 3);
		if (review != null) {
			et.begin();
			em.remove(review);
			et.commit();
			
			System.out.println("Data Removed Successfully");
		} else {
			System.out.println("Data Not Found");
		}
	}
}
