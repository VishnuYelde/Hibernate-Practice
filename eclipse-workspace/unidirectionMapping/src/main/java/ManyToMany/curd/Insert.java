package ManyToMany.curd;

import java.util.Arrays;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Doctor d1 = new Doctor();
		d1.setDid(1);
		d1.setDname("Vishnu");
		d1.setDegree("MBBS");
		
		Doctor d2 = new Doctor();
		d2.setDid(2);
		d2.setDname("Utkarsh");
		d2.setDegree("MD");
		
		Patient p1 = new Patient();
		p1.setPid(101);
		p1.setPname("Allen");
		p1.setDisease("High Fever");
		
		Patient p2 = new Patient();
		p2.setPid(102);
		p2.setPname("King");
		p2.setDisease("Jaundice");
		
		Patient p3 = new Patient();
		p3.setPid(103);
		p3.setPname("Tony");
		p3.setDisease("Cold");
		
		Patient p4 = new Patient();
		p4.setPid(104);
		p4.setPname("Smith");
		p4.setDisease("Dengu");
		
		d1.setPatients(Arrays.asList(p1, p2, p3));
		d2.setPatients(Arrays.asList(p4));
		
		et.begin();
		em.persist(d1);
		em.persist(d2);  
//		em.persist(p1);  // By using cascade in the Entity class of reference mapping.
//		em.persist(p2);  // Hibernate will take care of adding all the patients automatically.
//		em.persist(p3);
//		em.persist(p4);
		et.commit();
		
		System.out.println("Data Saved Successfully");
		
		
		
	}
}
