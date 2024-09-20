package com.serve.models;


public class UserModel{
	private int id;
	private String fName;
	private String email;
	private String password;
	private String phonenumber;
	private String profilePic;
	private String regDate;
	private String laaLogDate;
	
	
	public UserModel() {
	}


	public UserModel(int id, String fName, String email, String password, String phonenumber) {
		this.id = id;
		this.fName = fName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
	}




	public UserModel(int id, String fName, String email, String password, String phonenumber, String profilePic,
			String regDate, String laaLogDate) {
		this.id = id;
		this.fName = fName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.profilePic = profilePic;
		this.regDate = regDate;
		this.laaLogDate = laaLogDate;
	}


	public UserModel(String fName, String email, String password, String phonenumber) {
		super();
		this.fName = fName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
	}

	public UserModel(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getLaaLogDate() {
		return laaLogDate;
	}


	public void setLaaLogDate(String laaLogDate) {
		this.laaLogDate = laaLogDate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", email=" + email + ", password=" + password + ", phonenumber="
				+ phonenumber + ", profilePic=" + profilePic + ", regDate=" + regDate + ", laaLogDate=" + laaLogDate
				+ "]";
	}
	
}
