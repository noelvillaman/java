package school;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enrolled {
	
	@Id
	@GeneratedValue
	private int studentID;
	private int courseID;
	private double grade;
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Enrolled studentID=" + studentID + ", courseID=" + courseID + ", grade=" + grade;
	}
	
	

}
