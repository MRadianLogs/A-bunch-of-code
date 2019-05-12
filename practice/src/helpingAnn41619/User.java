/*
 * File name: User.java
 *
 * Programmer: Ann Gauger
 * ULID: amgauge
 *
 * Date: Apr 14, 2019
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Terry Plickebaum 
 * Lab Section: 12
 * Lab Instructor: Kumar Rakholia
 */
package helpingAnn41619;

/**
 *<insert class description here>”
 *
 * @author Ann Gauger
 *
 */
public class User
{
	
	private String userName;
	private String password;
	private String encryption;
	private String role;
	
	public User(String userName, String encryption, String password, String role)
	{
		this.userName = userName;
		this.password = password;
		this.encryption = encryption;
		this.role = role;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEncryption()
	{
		return encryption;
	}

	public void setEncryption(String encryption)
	{
		this.encryption = encryption;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	
	
}
