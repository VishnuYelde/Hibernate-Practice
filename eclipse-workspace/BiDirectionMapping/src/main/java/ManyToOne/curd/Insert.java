package ManyToOne.curd;

import java.util.Arrays;

import ManyToOne.entity.Product;
import ManyToOne.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p1 = new Product();
		p1.setPid(1);
		p1.setPname("Titan Watch");
		p1.setPrice(6000);

		Product p2 = new Product();
		p2.setPid(2);
		p2.setPname("Spark Shoes");
		p2.setPrice(2000);

		Review r1 = new Review();
		r1.setRid(101);
		r1.setMessage("Excellent");
		r1.setProduct(p1);

		Review r2 = new Review();
		r2.setRid(102);
		r2.setMessage("Good");
		r2.setProduct(p1);

		Review r3 = new Review();
		r3.setRid(103);
		r3.setMessage("Great");
		r3.setProduct(p2);

		p1.setReviews(Arrays.asList(r1, r2));
		p2.setReviews(Arrays.asList(r3));

		et.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		et.commit();

		System.out.println("Data Saved Successfully");

	}
}
