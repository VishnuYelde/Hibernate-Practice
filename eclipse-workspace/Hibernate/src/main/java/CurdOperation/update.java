package CurdOperation;

import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class update{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee employee= em.find(Employee.class, 102);		
		
		if (employee != null) {
			employee.setSal(92500);
			
			et.begin();
			em.merge(employee);
			et.commit();
			
			System.out.println("Employee details updated");
		}else {
			System.out.println("Employee Not Found");
		}
	}
}