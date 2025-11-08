package UniMapingCurd;


import entity.Car;
import entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction eTransaction = em.getTransaction();
		
		Car car = em.find(Car.class, 102);
		
		if (car != null) {
			car.setCbrand("Mahindra Thar");
			car.setCprice(1400000);
			
			Engine engine = car.getEngine();
			car.setEngine(engine);
			
			engine.setEngcc(1800);
			
			eTransaction.begin();
			em.merge(car);
			eTransaction.commit();
			
			System.out.println("Data Saved");
		} else {
			System.out.println("Data Not Found");
		}
	}
}
