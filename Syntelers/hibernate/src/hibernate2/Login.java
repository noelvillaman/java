package hibernate2;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
	@Id
	@Column(name="UserName")
	private String userName;
	@Column(name="password")
	private String passWord;
	
	public String getUsername() {
		return userName;
	}
	
	//Default constructor now
	public Login() {}


	public void setUsername(String username) {
		this.userName = username;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
