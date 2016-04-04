package school;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "Courses")
public class Courses {
	@Id
	@GeneratedValue
	private int courseID;
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "credits")
	private int credits;
	
	public Courses(){}

	public Courses(int courseID, String courseName, int credits) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credits = credits;
	}



	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Courses [courseID=" + courseID + ", courseName=" + courseName + ", credits=" + credits + "]";
	}
	
	

}
