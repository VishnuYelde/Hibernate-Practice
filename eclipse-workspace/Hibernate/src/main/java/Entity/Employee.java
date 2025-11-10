package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee{
	
	@Id
	private int eid;
	private String ename;
	private String email;
	private double sal;
	
	// getters and setters methods
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
}