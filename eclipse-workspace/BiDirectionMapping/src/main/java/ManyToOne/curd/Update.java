package ManyToOne.curd;

import java.util.List;

import ManyToOne.entity.Product;
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

		Product product = em.find(Product.class, 1);
		if (product != null) {

			et.begin();

			product.setPname("Titan Watch 3.0 Pro");
			product.setPrice(8000);

			List<Review> rList = product.getReviews();
			for (Review review : rList) {
				if (review.getRid() == 102) {
					review.setMessage("Worth for Money, Great Product");
					em.merge(review);
					break;
				}
			}

			em.merge(product);
			et.commit();
			
			System.out.println("Data Saved Successfully");
		} else {
			System.out.println("Product Not Found");
		}
	}
}
