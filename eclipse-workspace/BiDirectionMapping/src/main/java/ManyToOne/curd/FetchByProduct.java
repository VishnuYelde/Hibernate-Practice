package ManyToOne.curd;

import java.util.List;

import ManyToOne.entity.Product;
import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByProduct {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();

		Product product = em.find(Product.class, 1);
		if (product != null) {
			System.out.println("============Product Details============");
			System.out.println("Product ID: " + product.getPid());
			System.out.println("Product Name: " + product.getPname());
			System.out.println("Product Price: " + product.getPrice());

			List<Review> rList = product.getReviews();
			for (Review review : rList) {
				System.out.println("==========Review Details==========");
				System.out.println("Review ID: " + review.getRid());
				System.out.println("Review Message: " + review.getMessage());
			}

		} else {
			System.out.println("Product Not Found");
		}

	}
}
