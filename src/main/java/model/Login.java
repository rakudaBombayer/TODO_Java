package model;

// ログイン情報を保持する

public class Login {
	
	private String user_id;
	
	private String user_pass;
	
	public Login(String user_id, String user_pass) {
		
		this.user_id = user_id;
		this.user_pass = user_pass;
			
	}
	
	public String getUserId() {return user_id;}
	public String getPass() {return user_pass;}
}