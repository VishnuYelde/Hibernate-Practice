package OneToOne.curd;

import OneToOne.entity.Car;
import OneToOne.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByCar {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();

		Car car = em.find(Car.class, 1);
		if (car != null) {
			System.out.println("===========Car Details===========");
			System.out.println("Car Id: " + car.getCid());
			System.out.println("Car Brand: " + car.getCbrand());
			System.out.println("Car Price: " + car.getCprice());

			Engine engine = car.getEngine();
			System.out.println("===========Engine Details===========");
			System.out.println("Engine Id: " + engine.getEid());
			System.out.println("Engine CC: " + engine.getEcc());

		} else {
			System.out.println("Car Not Found");
		}

	}

}
