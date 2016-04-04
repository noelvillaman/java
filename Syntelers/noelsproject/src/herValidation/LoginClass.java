package herValidation;

import com.opensymphony.xwork2.ActionSupport;

public class LoginClass extends ActionSupport{
	String userName;
	String password;
	
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		if(!userName.equals("A")&& !password.equals("A"))
			addActionError("Username or passwor is invalid");
		if ((userName.trim()).length()==0) {
			addFieldError("userName",getText("user.required"));			
		}
		if((password.trim()).length()==0) {
			addFieldError("password", getText("password.required"));			
		}
		System.out.println("Validate Method");
			
	}
}
