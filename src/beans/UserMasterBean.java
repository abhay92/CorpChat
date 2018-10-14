package beans;

public class UserMasterBean {

	private int userId;
	private String userName;
	private String password;
	private String userType;
	private String status;
	private String name;
	
	public UserMasterBean()
	{
		
	}
	
	public UserMasterBean(int userId, String userName, String password, String userType, String status, String name)
	{
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.status = status;
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
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
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
