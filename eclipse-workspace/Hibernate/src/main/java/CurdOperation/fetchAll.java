package CurdOperation;

import java.util.List;


import Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class fetchAll{

	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		// JPQL query to fetch all data of the Employee table
		// 1.Index based parameter
		String q1 = "select e from Employee e where e.sal=?1";
		Query query = em.createQuery(q1);		
		query.setParameter(1, "80000"); // set the parameter for dynamic query of its placeholder
		
		
		// 2.Naming based parameter
		String q2 = "select e from Employee e where e.ename=:empname and e.sal=:empsal";
		Query query2 = em.createQuery(q2);
		query2.setParameter("empname", "Allen");
		query2.setParameter("empsal", "92500");
		List<Employee> list2 = query2.getResultList();
		
		System.out.println("=========================Employees data=========================");
		for(Employee employee : list2){
			System.out.println("Eid: " + employee.getEid());
			System.out.println("Ename: " + employee.getEname());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSal());
			System.out.println("---------------------------------------------------------------");
		}

		// list to store the employee record
		List<Employee> list1 = query.getResultList();
		
		
		System.out.println("=========================Employees data=========================");
		for(Employee employee : list1){
			System.out.println("Eid: " + employee.getEid());
			System.out.println("Ename: " + employee.getEname());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSal());
			System.out.println("---------------------------------------------------------------");
		}
	}
}