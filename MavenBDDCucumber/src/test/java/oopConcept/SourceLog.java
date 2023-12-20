package oopConcept;

public class SourceLog {

	private String userID;
	private String password;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login(String userId, String password) {
		System.out.println(userID);
		System.out.println(password);
	}

}