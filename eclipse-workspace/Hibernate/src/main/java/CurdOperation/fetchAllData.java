package CurdOperation;

import java.util.List;

import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class fetchAllData{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		// JPQL query
		List<Employee> eList = em.createQuery("select e from Employee e order by eid", Employee.class).getResultList();
		
		// Native SQL Query
//		List<Employee> eList2 = em.createNativeQuery("select * from employee", Employee.class).getResultList();
		
		
		System.out.println("===============Employees data===============");
		for (Employee employee : eList) {
			System.out.println("Eid: " + employee.getEid());
			System.out.println("Ename: " + employee.getEname());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSal());
			System.out.println("============================================");
		}
	}
}