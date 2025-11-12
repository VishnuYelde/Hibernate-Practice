package OneToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Engine {
	@Id
	private int eid;
	private double ecc;

	@OneToOne(mappedBy = "engine")
	private Car car;

	public int getEid() {
		return eid;
	}

	public void setEid(int engid) {
		this.eid = engid;
	}

	public double getEcc() {
		return ecc;
	}

	public void setEcc(double ecc) {
		this.ecc = ecc;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
