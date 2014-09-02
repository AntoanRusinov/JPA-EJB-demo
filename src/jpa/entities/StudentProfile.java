package jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jpa.entities.enums.EducationForm;
import jpa.entities.enums.YearOfEducation;

@Entity
@Table(name = "student_profile")
public class StudentProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	public StudentProfile() {

	}

	public StudentProfile(Student student1) {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_profile_id")
	private int studentProfileId;

	@Column(name = "faculty_number")
	private int facultyNumber;

	@Column(name = "education_form")
	private EducationForm educationFrom;

	@Column(name = "specialty")
	private String specialty;

	@Column(name = "year_of_education")
	private YearOfEducation yearOfEducation;

	@Column(name = "average_mark")
	private int averageMark;

	@Column(name = "student_rights")
	private boolean studentRights;

	public int getStudentProfileId() {
		return studentProfileId;
	}

	public void setStudentProfileId(int studentProfileId) {
		this.studentProfileId = studentProfileId;
	}

	public int getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(int facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public EducationForm getEducationFrom() {
		return educationFrom;
	}

	public void setEducationFrom(EducationForm educationFrom) {
		this.educationFrom = educationFrom;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public YearOfEducation getYearOfEducation() {
		return yearOfEducation;
	}

	public void setYearOfEducation(YearOfEducation yearOfEducation) {
		this.yearOfEducation = yearOfEducation;
	}

	public int getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}

	public boolean isStudentRights() {
		return studentRights;
	}

	public void setStudentRights(boolean studentRights) {
		this.studentRights = studentRights;
	}

	@Override
	public String toString() {
		return "StudentProfile [studentProfileId=" + studentProfileId
				+ ", facultyNumber=" + facultyNumber + ", educationFrom="
				+ educationFrom + ", specialty=" + specialty
				+ ", yearOfEducation=" + yearOfEducation + ", averageMark="
				+ averageMark + ", studentRights=" + studentRights + "]";
	}

}
