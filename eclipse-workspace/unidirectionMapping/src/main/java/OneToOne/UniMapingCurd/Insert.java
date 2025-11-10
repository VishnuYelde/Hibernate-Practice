package OneToOne.UniMapingCurd;

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
		
		Car car = new Car();
		car.setCid(104);
		car.setCbrand("Hyundai");
		car.setCprice(1600000);
		
		Engine eng = new Engine();
		eng.setEngid(4);
		eng.setEngcc(1600);
		
		car.setEngine(eng);
		
		et.begin();
		em.persist(car);
		em.persist(eng);
		et.commit();
		
		System.out.println("Data Saved");
		
	}
}
