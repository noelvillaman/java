package todaysAssignment;

import com.opensymphony.xwork2.ActionSupport;

public class LoginClass extends ActionSupport{
	String firstname;
	String lastname;
	String password;
	String email;
	String chk1;
	String chk2;
	String chk3;
	String chk4;
	String rdbtn1;
	String rdbtn2;
	String rdbtn3;
	String rdbtn4;
	String box1;
	String rdbnt;
	String opt1;
	
	public String getBox1() {
		return box1;
	}

	public void setBox1(String box1) {
		this.box1 = box1;
	}

	public String getRdbnt() {
		return rdbnt;
	}

	public void setRdbnt(String rdbnt) {
		this.rdbnt = rdbnt;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
	public String getChk1() {
		return chk1;
	}

	public void setChk1(String chk1) {
		this.chk1 = chk1;
	}

	public String getChk2() {
		return chk2;
	}

	public void setChk2(String chk2) {
		this.chk2 = chk2;
	}

	public String getChk3() {
		return chk3;
	}

	public void setChk3(String chk3) {
		this.chk3 = chk3;
	}

	public String getChk4() {
		return chk4;
	}

	public void setChk4(String chk4) {
		this.chk4 = chk4;
	}

	public String getRdbtn1() {
		return rdbtn1;
	}

	public void setRdbtn1(String rdbtn1) {
		this.rdbtn1 = rdbtn1;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setUserName(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String run(){
		System.out.println("Execute Method");
		return SUCCESS;
	}
	public void validate(){
		if(!firstname.equals("Noel")&& !lastname.equals("Villaman"))
			addActionError("Name or last name is invalid");
		if ((firstname.trim()).length()==0) {
			addFieldError("firstname",getText("firstname.required"));			
		}
		if((password.trim()).length()==0) {
			addFieldError("lastname", getText("lastname.required"));			
		}
		if((email.trim()).length()==0){
			addFieldError("email", getText("email.required"));
		}
		System.out.println("Validate Method");
			
	}
}
