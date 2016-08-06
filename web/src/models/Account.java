package models;

public class Account {
private String username;
private String password;
private String role;
private String fullname;
private String address;
private String email;

public Account(String username, String password, String role, String fullname, String address, String email) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
	this.fullname = fullname;
	this.address = address;
	this.email = email;
}
public Account(){
	
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "Account [username=" + username + ", password=" + password + ", role=" + role + ", fullname=" + fullname
			+ ", address=" + address + ", email=" + email + "]";
}

}
