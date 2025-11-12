package OneToOne.curd;

import OneToOne.entity.Car;
import OneToOne.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();

		Engine engine = em.find(Engine.class, 102);

		if (engine != null) {

			System.out.println("===========Engine Details===========");
			System.out.println("Engine Id: " + engine.getEid());
			System.out.println("Engine CC: " + engine.getEcc());

			Car car = engine.getCar();
			System.out.println("===========Car Details===========");
			System.out.println("Car Id: " + car.getCid());
			System.out.println("Car Brand: " + car.getCbrand());
			System.out.println("Car Price: " + car.getCprice());

		} else {
			System.out.println("Engine Not Found");
		}
	}
}
