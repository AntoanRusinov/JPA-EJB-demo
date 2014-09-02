package jpa.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	public Student() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "password")
	private String password;

	@Column(name = "activated")
	private boolean activated;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_student_profile")
	private StudentProfile fkStudentProfile;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public StudentProfile getFkStudentProfile() {
		return fkStudentProfile;
	}

	public void setFkStudentProfile(StudentProfile fkStudentProfile) {
		this.fkStudentProfile = fkStudentProfile;
	}

	@Override
	public String toString() {
		return "Studenst [studentId=" + studentId + ", loginName=" + loginName
				+ ", password=" + password + ", activated=" + activated
				+ ", fkStudentProfile=" + fkStudentProfile + "]";
	}

}
