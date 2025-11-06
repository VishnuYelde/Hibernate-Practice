package CurdOperation;

import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert{
	
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper"); // load driver and create connection
		System.out.println("Looking for persistence provider...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		System.out.println("Factory created: " + emf);

		EntityManager em = emf.createEntityManager(); //provide methods to perform CURD operations
//		methods like 
//		persist() --> save/insert
//		merge() --> update
//		find() --> fetch
//		remove() --> delete
		
		EntityTransaction et = em.getTransaction(); // to handle the transaction like insert, update, delete Only DML commands
		
		Employee employee = new Employee();
		employee.setEid(101);
		employee.setEname("King");
		employee.setEmail("king@gmail.com");
		employee.setSal(95000);
		
		et.begin();
		em.persist(employee);
		et.commit();
		
		System.out.println("Employee details saved");
		
		
	}
}