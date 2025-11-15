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
		d1.setDname("Vishu");
		d1.setDegree("MBBS");
		
		Doctor d2 = new Doctor();
		d2.setDid(2);
		d2.setDname("Rishi");
		d2.setDegree("MBBS");
		
		Patient p1 = new Patient();
		p1.setPid(101);
		p1.setPname("Vishal");
		p1.setDisease("Mulvyad");
		
		Patient p2 = new Patient();
		p2.setPid(102);
		p2.setPname("Yash");
		p2.setDisease("Fever");
		
		Patient p3 = new Patient();
		p3.setPid(103);
		p3.setPname("Vishal");
		p3.setDisease("Mulvyad");
		
		d1.setPatients(Arrays.asList(p1, p2));
		d2.setPatients(Arrays.asList(p3));
		
		et.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		et.commit();
		
		
		System.out.println("Data Saved Successfully");
	}
}
