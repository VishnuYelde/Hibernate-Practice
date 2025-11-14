package ManyToOne.curd;

import ManyToOne.entity.Product;
import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByReview {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();

		Review review = em.find(Review.class, 101);
		if (review != null) {
			System.out.println("==========Review Details==========");
			System.out.println("Review ID: " + review.getRid());
			System.out.println("Review Message: " + review.getMessage());

			Product product = review.getProduct();
			System.out.println("==========Product Details==========");
			System.out.println("Product ID: " + product.getPid());
			System.out.println("Product Name: " + product.getPname());
			System.out.println("Product Price: " + product.getPrice());

		} else {
			System.out.println("Review Not Found");
		}
	}
}
