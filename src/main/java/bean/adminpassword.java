package bean;

public class adminpassword {
	private String usermail;
	private int pass;
	private String username;
	
	
	
	public adminpassword(String usermail, int pass, String username) {
		super();
		this.usermail = usermail;
		this.pass = pass;
		this.username = username;
	}
	public String getUsermail() {
		return usermail;
	}
	public int getPass() {
		return pass;
	}
	public String getUsername() {
		return username;
	}


}
