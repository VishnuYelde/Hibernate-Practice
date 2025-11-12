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
			
//			no need of merge()
			
			
//			doctor.setDname("Vishnu Yelde");
//			List<Patient> pList = doctor.getPatients();
//            for (Patient patient : pList) {
//                if (patient.getPid() == 103) {
//                    patient.setPname("Tony Stark");
//                    break;
//                }
//            }
//            et.commit();
			
			List<Patient> pList = doctor.getPatients();
			for (Patient patient : pList) {
				if (patient.getPid() == 103) {
					patient.setPname("Tony Stark");
					
					em.merge(patient);
					break;
				}
			}
			
			em.merge(doctor);
			et.commit();
			
			System.out.println("Details Saved Successfully");
		} else {
			System.out.println("Doctor Not Found");
		}
	}
}
