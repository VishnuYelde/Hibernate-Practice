package OneToOne.curd;

import OneToOne.entity.Car;
import OneToOne.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Car c1 = new Car();
		c1.setCid(1);
		c1.setCbrand("Tata Harrier");
		c1.setCprice(2500000);

		Car c2 = new Car();
		c2.setCid(2);
		c2.setCbrand("Mahindra Thar");
		c2.setCprice(1500000);
		
		Car c3 = new Car();
		c3.setCid(3);
		c3.setCbrand("Hyundai");
		c3.setCprice(1800000);

		Engine e1 = new Engine();
		e1.setEid(101);
		e1.setEcc(1500);

		Engine e2 = new Engine();
		e2.setEid(102);
		e2.setEcc(900);
		
		Engine e3 = new Engine();
		e3.setEid(103);
		e3.setEcc(1000);

		c1.setEngine(e1);
		c2.setEngine(e2);
		c3.setEngine(e3);
		
		et.begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		et.commit();

		System.out.println("Car Details Saved Successfully");

	}
}
