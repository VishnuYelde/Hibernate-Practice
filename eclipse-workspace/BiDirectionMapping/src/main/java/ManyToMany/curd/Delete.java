package ManyToMany.curd;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		// Easy Method
		Doctor doctor = em.find(Doctor.class, 1);
		Patient patient = em.find(Patient.class, 102);
		
		if (doctor != null && patient != null) {
			et.begin();
			doctor.getPatients().remove(patient);
//			em.merge(doctor);
			et.commit();
			
			et.begin();
//			patient = em.find(Patient.class, 103);
			em.remove(patient);
			et.commit();
			System.out.println("Data Removed Successfully");
			
		} else {
			System.out.println("Doctor Or Patient Not Found");
		}
		
		
		// Lenthy Method for delete data and relation link
//		Doctor doctor = em.find(Doctor.class, 1);
//		if (doctor != null) {
//			et.begin();
//			
//			List<Patient> pList = doctor.getPatients();
//			Patient removePatient = null;
//			
//			for (Patient patient : pList) {
//				if (patient.getPid() == 101) {
//					removePatient = patient;
//					break;
//				}
//			}
//			if (removePatient != null) {
//				pList.remove(removePatient);
//				em.remove(em.find(Patient.class, removePatient.getPid()));
//				et.commit();
//				
//			}
//
//			System.out.println("Data Removed Successfully");
//			
//		} else {
//			System.out.println("Doctor not Found");
//		}
	}
}
