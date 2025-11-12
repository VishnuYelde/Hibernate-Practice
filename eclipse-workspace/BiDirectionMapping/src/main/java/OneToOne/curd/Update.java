package OneToOne.curd;

import OneToOne.entity.Car;
import OneToOne.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Car car = em.find(Car.class, 1);
		if (car != null) {
			car.setCbrand("Tata Harrier 2.0");

			Engine engine = car.getEngine();
			engine.setEcc(1800);

			et.begin();
			em.merge(car);
			et.commit();

			System.out.println("Details Saved Successfully");
		} else {
			System.out.println("Car Not Found");
		}
	}
}
