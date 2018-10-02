/*
 * File name: List.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Aug 10, 2017
 */
package reyesProjects;

import java.util.ArrayList;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class ActivityList
{
	private ArrayList<Activity> list;
	
	public ActivityList()
	{
		list = new ArrayList();
	}
	
	public Activity getActivity(int activityNum)
	{
		return list.get(activityNum);
	}
	
	public void addActivity(String activityName, String description)
	{
		Activity newActivity = new Activity(activityName, description);
		list.add(newActivity);
	}
	
	public void deleteActivity(int activityNum)
	{
		list.remove(activityNum);
	}
	
	public void checkComplete(int numActivity)
	{
		getActivity(numActivity).completeActivity();
	}
	
}
