/*
 * File name: Customer.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Oct 28, 2017
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Customer
{
	private String fullName;
	private String fullAddress;
	private String phoneNumber;
	
	public Customer()
	{
		
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public String getFullAddress()
	{
		return fullAddress;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setFullName(String newFullName)
	{
		fullName = newFullName;
	}
	
	public void setFullAddress(String newFullAddress)
	{
		fullAddress = newFullAddress;
	}
	
	public void setPhoneNumber(String newPhoneNumber)
	{
		phoneNumber = newPhoneNumber;
	}
	
	public void getCustomerInfo(Scanner input)
	{
		System.out.print("Please enter customer's full name: ");
		fullName = input.nextLine();
		System.out.print("\nPlease enter customer's full address (street address, town): ");
		fullAddress = input.nextLine();
		System.out.print("\nPlease enter customer's phone number: ");
		phoneNumber = input.nextLine();
	}
	
	public String toString()
	{
		return "Customer name: " + fullName + "\nCustomer Address: " + fullAddress + "\nPhone Number: " + phoneNumber;
	}
	
	
}
