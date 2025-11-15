package ManyToMany.curd;

import java.util.List;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchByDoctor {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		
		Doctor doctor = em.find(Doctor.class, 1);
		if (doctor != null) {
			System.out.println("==========Doctor Details==========");
			System.out.println("Doctor ID: "+doctor.getDid());
			System.out.println("Doctor Name: "+doctor.getDname());
			System.out.println("Doctor Degree: "+doctor.getDegree());
			
			List<Patient> pList = doctor.getPatients();
			for (Patient patient : pList) {
				System.out.println("==========Patient Details==========");
				System.out.println("Patient ID: "+patient.getPid());
				System.out.println("Patient Name: "+patient.getPname());
				System.out.println("Patient Disease: "+patient.getDisease());
			}
			
			System.out.println("Data Fetch Successfully");
			
		} else {
			System.out.println("Doctor not Found");
		}
	}
}
