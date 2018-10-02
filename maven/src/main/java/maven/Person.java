/*
 * File name: Person.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Feb 7, 2018
 */
package maven;

/**
 * This is the Person class. It is based off some general ideas of a person, including having a first and last name, 
 * and an age. The purpose of this class is for learning Maven. The 
 * class where these methods and variables are tested is called the PersonTest class.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Person
{
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName,String lastName,int age)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
	}
	
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public int getAge() {return age;}
}
