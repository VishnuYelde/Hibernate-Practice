package CurdOperation;

import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class fetchData{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		Employee employee = em.find(Employee.class, 101);
		
		if (employee != null) {
			System.out.println("===========Employee Data===========");
			System.out.println("Eid: " + employee.getEid());
			System.out.println("Ename: " + employee.getEname());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSal());
		} else {
			System.out.println("Employee data not found");
		}
	}
}