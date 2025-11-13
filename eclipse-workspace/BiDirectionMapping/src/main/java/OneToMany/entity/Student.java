package OneToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	private String std;

	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

}
