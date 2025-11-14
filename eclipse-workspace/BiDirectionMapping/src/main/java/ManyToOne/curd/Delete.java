package ManyToOne.curd;

import java.util.List;

import ManyToOne.entity.Product;
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

		Product product = em.find(Product.class, 1);
		if (product != null) {
			List<Review> rList = product.getReviews();
			Review removeReview = null;
			
			for (Review review : rList) {
				if (review.getRid() == 102) {
					removeReview = review;
					break;
				}
			}
			
			if (removeReview != null) {
				et.begin();
				rList.remove(removeReview);
				em.remove(removeReview);
				et.commit();

				System.out.println("Review Data Removed Successfully");
			} else {
				System.out.println("Product Not Found");
			}
			
			System.out.println("Data Removed Successfully");
		} else {
			System.out.println("Product Not Found");
		}
	}
}
