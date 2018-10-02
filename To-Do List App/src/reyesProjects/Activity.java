/*
 * File name: Activity.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Aug 10, 2017
 */
package reyesProjects;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Activity
{
	private String name;
	private String description;
	private boolean completed;
	
	public Activity(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public boolean checkCompleted()
	{
		return completed;
	}
	
	public void completeActivity()
	{
		completed = true;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setDescription(String newDescription)
	{
		this.description = newDescription;
	}
}
