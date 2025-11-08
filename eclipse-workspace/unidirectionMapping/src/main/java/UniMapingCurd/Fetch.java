package UniMapingCurd;


import entity.Car;
import entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		Car car = em.find(Car.class, 101);
		
		if (car != null) {
			System.out.println("===============Car Details===============");
			System.out.println("Car Id:" +car.getCid());
			System.out.println("Car Brand:" +car.getCbrand());
			System.out.println("Car Price:" +car.getCprice());
			
			Engine engine = car.getEngine();
			System.out.println("===============Engine Details===============");
			System.out.println("Engine Id:" +engine.getEngid());
			System.out.println("Engine CC:" +engine.getEngcc());
		} else {
			System.out.println("Car Not Found");
		}	
	}
}
