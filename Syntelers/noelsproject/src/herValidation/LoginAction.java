/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herValidation;

/**
 *
 * @author LS5002117
 * 
 * Creating the POJO to be used with the Action Class
 */
public class LoginAction {
    String userName;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String execute(){
        if(userName.equals("A") && password.equals("A"))
            return "fail";
        else
            return "success";
    }
}
