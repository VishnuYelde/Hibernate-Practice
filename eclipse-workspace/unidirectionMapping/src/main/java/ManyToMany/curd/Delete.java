package ManyToMany.curd;

import java.util.List;

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
		
		Doctor doctor = em.find(Doctor.class, 1);
		if (doctor != null) {
			
			List<Patient> pList = doctor.getPatients();
			Patient removePatient = null;
			
			for (Patient patient : pList) {
				if (patient.getPid() == 102) {
					removePatient = patient;
					break;
				}
			}
			
			if (removePatient != null) {
				et.begin();
				pList.remove(removePatient);  // remove link first
				em.merge(doctor);   // update join table 
				em.remove(em.find(Patient.class, removePatient.getPid()));  // delete record
				et.commit();
				
				System.out.println("Details Removed Successfully");
			} else {
                System.out.println("Patient Not Found");
            }
			
		} else {
			System.out.println("Doctor Not Found");
		}
	}
}
