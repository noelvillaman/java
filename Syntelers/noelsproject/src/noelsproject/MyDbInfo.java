package noelsproject;

public class MyDbInfo {
	private int cid;
	private String cname;
	private int cfees;
	

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCfees() {
        return cfees;
    }

    public void setCfees(int cfees) {
        this.cfees = cfees;
    }
	
    public String execute1(){
        if( cname.equals("Noel") || cfees >=1000 || cfees <= 4 || cfees < 0)
        		
            return "fail";
        else
            return "success";
    }

}
