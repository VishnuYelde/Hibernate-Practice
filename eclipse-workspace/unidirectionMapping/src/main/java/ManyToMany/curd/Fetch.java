package ManyToMany.curd;

import java.util.List;

import ManyToMany.entity.Doctor;
import ManyToMany.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();

		Doctor d1 = em.find(Doctor.class, 1);

		if (d1 != null) {
			System.out.println("============Doctor Details============");
			System.out.println("Doctor ID: " + d1.getDid());
			System.out.println("Doctor Name: " + d1.getDname());
			System.out.println("Doctor Degree: " + d1.getDegree());

			System.out.println("============Patients Details============");
			List<Patient> pList = d1.getPatients();
			for (Patient patient : pList) {
				System.out.println("Patient ID: " + patient.getPid());
				System.out.println("Patient Pname: " + patient.getPname());
				System.out.println("Patient Disease: " + patient.getDisease());
				System.out.println("---------------------------------------");
			}

		} else {
			System.out.println("Doctor Not Found");
		}
	}
}
