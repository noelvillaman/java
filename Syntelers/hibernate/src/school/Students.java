package school;

import javax.persistence.*;


@Entity
@Table(name="Students")
public class Students {
	@Id
	@GeneratedValue
	@Column(name = "studentID")
	private int studentID;
	
	@Column(name = "sname")
	private String sname;
	
	@Column(name = "slastName")
	private String slastName;
	
	@Column(name = "saddress")
	private String saddress;
	
	@Column(name = "scity")
	private String scity;
	
	@Column(name = "szipcode")
	private String szipcode;
	
	
	
	public Students() {}
	
	
	public Students(int studentID, String sname, String slastName, String saddress, String scity, String szipcode) {
		super();
		this.studentID = studentID;
		this.sname = sname;
		this.slastName = slastName;
		this.saddress = saddress;
		this.scity = scity;
		this.szipcode = szipcode;
	}


	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSlastName() {
		return slastName;
	}
	public void setSlastName(String slastName) {
		this.slastName = slastName;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSzipcode() {
		return szipcode;
	}
	public void setSzipcode(String szipcode) {
		this.szipcode = szipcode;
	}
	
	
	@Override
	public String toString() {
		return "Students [studentID=" + studentID + ", sname=" + sname + ", slastName=" + slastName + ", saddress="
				+ saddress + ", scity=" + scity + ", szipcode=" + szipcode + "]";
	}
	
	

}
