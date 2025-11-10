package ManyToOne.Curd;

import ManyToOne.entity.Product;
import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Review review = em.find(Review.class, 1);
		
		
		if (review != null) {			
			
			Product product = review.getProduct();
			System.out.println("==================Product Data==================");
			System.out.println("Product ID: "+product.getPid());
			System.out.println("Product Name: "+product.getPname());
			System.out.println("Product Price: "+product.getPrice());
			
			System.out.println("==================Review Data===================");
			System.out.println("Review ID: "+review.getRid());
			System.out.println("Message: "+review.getMessage());
			
			
		} else {
			System.out.println("Data Not Found");
		}
	}

}
