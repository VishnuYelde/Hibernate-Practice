package ManyToMany.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Doctor {
	@Id
	private int did;
	private String dname;
	private String degree;

	@ManyToMany(cascade = CascadeType.ALL)  // Insert Patients in the table automatically. Don't need to call persist() again and again for patients.
	private List<Patient> patients;			// But but for doctor you have to call it again and again Or you can use List and add doctor using ForEach Loop.

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
