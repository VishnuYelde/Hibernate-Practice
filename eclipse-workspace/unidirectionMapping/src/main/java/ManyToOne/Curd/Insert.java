package ManyToOne.Curd;

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
		
		Product product = new Product();
		product.setPid(101);
		product.setPname("Titan Watch");
		product.setPrice(6000);
		
		Review r1 = new Review();
		r1.setRid(1);  
		r1.setMessage("Worth for Money");
		r1.setProduct(product);
		
		Review r2 = new Review();
		r2.setRid(2);  
		r2.setMessage("Excellent Product");
		r2.setProduct(product);
		
		Review r3 = new Review();
		r3.setRid(3);  
		r3.setMessage("Brand is Brand");
		r3.setProduct(product);
		
		et.begin();
		em.persist(product);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		et.commit();
		
		System.out.println("Data Saved Successfully");
	}
}
