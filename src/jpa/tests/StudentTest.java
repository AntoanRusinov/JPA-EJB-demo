package jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.entities.Student;
import jpa.entities.StudentProfile;
import jpa.entities.enums.EducationForm;
import jpa.entities.enums.YearOfEducation;

import org.testng.annotations.Test;

public class StudentTest {

	@Test
	public static void test() {

		Exception expectedException = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-core-db-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction txn = null;

		try {
			txn = entityManager.getTransaction();
			txn.begin();
			entityManager.persist(createFirstStudent());
			entityManager.persist(createSecondStudent());
			txn.commit();

			System.out.println("FIRST STUDENT: ");
			getPlayerData(createFirstStudent());
			System.out.println();
			System.out.println("SECOND STUDENT: ");
			getPlayerData(createSecondStudent());

		} catch (Exception ex) {
			expectedException = ex;
			assert expectedException == null;
			txn.rollback();
			ex.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		assert entityManager != null;
		assert entityManagerFactory != null;
		assert txn != null;
	}

	public static Student createFirstStudent() {

		Student student1 = new Student();
		StudentProfile studentProfile = new StudentProfile(student1);

		student1.setStudentId(1);
		student1.setLoginName("student_4562");
		student1.setPassword("pass_secret");
		student1.setActivated(true);
		student1.setFkStudentProfile(studentProfile);

		studentProfile.setAverageMark(5);
		studentProfile.setEducationFrom(EducationForm.REGULARLY);
		studentProfile.setFacultyNumber(16212);
		studentProfile.setSpecialty("Molecular Biology");
		studentProfile.setStudentProfileId(1);
		studentProfile.setStudentRights(true);
		studentProfile.setYearOfEducation(YearOfEducation.FOURTH);

		return student1;
	}

	public static Student createSecondStudent() {

		Student student2 = new Student();
		StudentProfile studentProfile = new StudentProfile(student2);

		studentProfile.setAverageMark(4);
		studentProfile.setEducationFrom(EducationForm.ABSENTIA);
		studentProfile.setFacultyNumber(90604);
		studentProfile.setSpecialty("Medicine");
		studentProfile.setStudentProfileId(2);
		studentProfile.setStudentRights(false);
		studentProfile.setYearOfEducation(YearOfEducation.FIFTH);

		student2.setStudentId(2);
		student2.setLoginName("excellent");
		student2.setPassword("pass_test");
		student2.setActivated(false);
		student2.setFkStudentProfile(studentProfile);

		return student2;
	}

	public static void getPlayerData(Student student) {

		System.out.println(student.getStudentId());
		System.out.println(student.getLoginName());
		System.out.println(student.getPassword());
		System.out.println(student.isActivated());
		System.out.println(student.getFkStudentProfile());

		assert student.getLoginName() != null;
		assert student.getPassword() != null;
	}

}
