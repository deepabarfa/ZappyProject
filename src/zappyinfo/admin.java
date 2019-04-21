package zappyinfo;
//getter setter function for admin 
public class admin 
{
	String uid;
	String password;
	
	public admin(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
