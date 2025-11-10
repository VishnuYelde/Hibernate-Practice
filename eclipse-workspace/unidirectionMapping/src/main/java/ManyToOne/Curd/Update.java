package ManyToOne.Curd;

import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Review review = em.find(Review.class, 2);
		if (review != null) {
			review.setMessage("Most Stylish Watch Ever");

			et.begin();
			em.merge(review);
			et.commit();

			System.out.println("Review Posted Successfully");
		} else {
			System.out.println("Review Not Found");
		}
	}

}
