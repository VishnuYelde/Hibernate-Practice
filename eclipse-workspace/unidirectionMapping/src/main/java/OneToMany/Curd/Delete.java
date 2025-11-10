package OneToMany.Curd;

import java.util.List;

import OneToMany.entity.College;
import OneToMany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("devloper");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		College college = em.find(College.class, 101);
		if (college != null) {
			List<Student> sList = college.getStudent();

			Student removeStudent = null;

			for (Student student : sList) {
				if (student.getSid() == 3) {
					removeStudent = student;
					break;
				}
			}
			if (removeStudent != null) {
				et.begin();
				sList.remove(removeStudent);
				em.remove(removeStudent);
				et.commit();

				System.out.println("Student Data Removed Successfully");
			} else {
				System.out.println("Student Data Not Found");
			}

			System.out.println("Data Removed Successfully");
		} else {
			System.out.println("College Data Not Found");
		}

	}
}
