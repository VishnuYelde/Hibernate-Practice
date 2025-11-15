package ManyToMany.curd;

import java.util.List;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Doctor doctor = em.find(Doctor.class, 1);
		if (doctor != null) {
			et.begin();
			
			doctor.setDname("Vishu Yelde");
			
			List<Patient> pList = doctor.getPatients();
			for (Patient patient : pList) {
				if(patient.getPid() == 101) {
					patient.setPname("Vishal Zhatu");
					em.merge(patient);
					break;
				}
			}
			
			em.merge(doctor);
			et.commit();
			
			System.out.println("Data Saved Successfully");
			
		} else {
			System.out.println("Doctor not Found");
		}
	}
}
