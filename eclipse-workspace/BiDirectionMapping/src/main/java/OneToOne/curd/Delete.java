package OneToOne.curd;

import OneToOne.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, 3);
		if (car != null) {
			et.begin();
			em.remove(car);
			et.commit();
			
			System.out.println("Car Data Deleted...");
		} else {
			System.out.println("Car Not Found");
		}
	}
}
