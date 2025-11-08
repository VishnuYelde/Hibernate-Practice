package UniMapingCurd;

import entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager eManager = emf.createEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		
		Car car = eManager.find(Car.class, 103);
		
		if(car != null) {
			eTransaction.begin();
			eManager.remove(car);
			eTransaction.commit();
			
			System.out.println("Data Deleted...");
			
		}
	}
}
