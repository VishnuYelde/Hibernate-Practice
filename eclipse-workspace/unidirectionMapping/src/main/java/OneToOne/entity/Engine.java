package OneToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {

	@Id
	private int engid;
	private double engcc;

	public int getEngid() {
		return engid;
	}

	public void setEngid(int engid) {
		this.engid = engid;
	}

	public double getEngcc() {
		return engcc;
	}

	public void setEngcc(double engcc) {
		this.engcc = engcc;
	}

}
