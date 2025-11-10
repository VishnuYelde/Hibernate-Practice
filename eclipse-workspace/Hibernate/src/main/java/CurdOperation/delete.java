package CurdOperation;

import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class delete{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee employee = em.find(Employee.class, 104);
		
		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			System.out.println("Employee data deleted");
		} else {
			System.out.println("Employee data not found");
		}
	}
}