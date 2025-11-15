package ManyToMany.curd;

import java.util.List;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByPatient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		Patient patient = em.find(Patient.class, 101);
		if (patient != null) {
			System.out.println("==========Patient Details==========");
			System.out.println("Patient ID: "+patient.getPid());
			System.out.println("Patient Name: "+patient.getPname());
			System.out.println("Patient Disease: "+patient.getDisease());
			
			List<Doctor> dList = patient.getDoctors();
			for (Doctor doctor : dList) {
			
				System.out.println("==========Doctor Details==========");
				System.out.println("Doctor ID: "+doctor.getDid());
				System.out.println("Doctor Name: "+doctor.getDname());
				System.out.println("Doctor Degree: "+doctor.getDegree());
				
			}
			
			System.out.println("Data Fetch Successfully");
			
		} else {
			System.out.println("Patient not Found");
		}
	}
}
